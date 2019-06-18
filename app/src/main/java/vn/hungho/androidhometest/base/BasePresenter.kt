package vn.hungho.androidhometest.base

import vn.hungho.androidhometest.network.RestManager

open class BasePresenter<V : IView> : IPresenter<V> {
    val restManager: RestManager = RestManager()
    private var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }

    override fun isAttachView(): Boolean {
        return mView != null
    }

    override fun getView(): V? {
        return mView
    }

    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}