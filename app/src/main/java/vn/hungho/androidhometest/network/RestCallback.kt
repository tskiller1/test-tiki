package vn.hungho.androidhometest.network

abstract class RestCallback<T> {
    abstract fun onSuccess(res: T)

    abstract fun onFailure(error: RestError)
}