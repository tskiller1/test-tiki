package vn.hungho.androidhometest.view.activity.main

import vn.hungho.androidhometest.base.IView
import vn.hungho.androidhometest.model.Product

interface IMain {
    interface IMainView : IView {
        fun onGetProductSuccess(response: List<Product>)
    }

    interface IMainPresenter {
        fun getProduct()
    }
}