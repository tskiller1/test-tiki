package vn.hungho.androidhometest.view.activity.main

import vn.hungho.androidhometest.base.BasePresenter
import vn.hungho.androidhometest.model.Product
import vn.hungho.androidhometest.network.RestCallback
import vn.hungho.androidhometest.network.RestError

class MainPresenter : BasePresenter<IMain.IMainView>(), IMain.IMainPresenter {
    override fun onCreate() {
        super.onCreate()
    }

    override fun getProduct() {
        getView()?.showLoading()
        restManager.getProducts((object : RestCallback<List<Product>>() {
            override fun onSuccess(res: List<Product>) {
                getView()?.onGetProductSuccess(res)
                getView()?.hideLoading()
            }

            override fun onFailure(error: RestError) {
                getView()?.showErrorMessage(error.message!!)
                getView()?.hideLoading()
            }
        }))
    }
}