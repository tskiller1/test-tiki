package vn.hungho.androidhometest.network

import retrofit2.Call
import retrofit2.http.GET
import vn.hungho.androidhometest.model.Product

interface ApiServices {
    @GET("products.json")
    fun getProduct(): Call<List<Product>>
}