package vn.hungho.androidhometest.base

interface IPresenter<V : IView> {
    fun attachView(view: V)

    fun detachView()

    fun isAttachView(): Boolean

    fun getView(): V?

    fun onCreate()
}