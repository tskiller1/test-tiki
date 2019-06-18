package vn.hungho.androidhometest.base

interface IView {
    fun showLoading()

    fun hideLoading()

    fun showErrorMessage(message: String)
}