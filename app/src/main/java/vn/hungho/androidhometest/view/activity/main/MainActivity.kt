package vn.hungho.androidhometest.view.activity.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import vn.hungho.androidhometest.R
import vn.hungho.androidhometest.base.BaseActivity
import vn.hungho.androidhometest.base.IOnAdapterListener
import vn.hungho.androidhometest.model.Product
import vn.hungho.androidhometest.view.adapter.ProductAdapter

class MainActivity : BaseActivity(), IMain.IMainView, IOnAdapterListener, View.OnClickListener {

    val mPresenter: MainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initListener()
    }

    fun initData() {
        rcv_product.layoutManager = LinearLayoutManager(this)

        mPresenter.attachView(this)

        mPresenter.getProduct()
    }

    fun initListener() {
        lnl_tiki_now.setOnClickListener(this)
    }

    override fun onGetProductSuccess(response: List<Product>) {
        rcv_product.adapter = ProductAdapter(this, response, this)
    }

    override fun onItemClickListener(view: View, position: Int, item: Any?) {
        val product: Product = item as Product
        Log.d("product", product.name)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.lnl_tiki_now -> {
                ckb_tiki_now.isChecked = !ckb_tiki_now.isChecked
            }
        }
    }
}
