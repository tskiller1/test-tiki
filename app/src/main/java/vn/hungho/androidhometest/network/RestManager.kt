package vn.hungho.androidhometest.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vn.hungho.androidhometest.app.AppManager
import vn.hungho.androidhometest.model.Product

class RestManager {
    fun getProducts(callback: RestCallback<List<Product>>) {
        AppManager.http_api().from(ApiServices::class.java).getProduct().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onFailure(RestError(404, "NOT FOUND"))
                    }
                } else {
                    callback.onFailure(RestError(-99, response.message()))
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                callback.onFailure(RestError(-99, t.message))
            }
        })

    }
}