package vn.hungho.androidhometest.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import vn.hungho.androidhometest.BuildConfig

class HttpHelper(baseURL: String) {
    var retrofit: Retrofit

    init {
        val okHttpClientBuilder = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        okHttpClientBuilder.addInterceptor(logging)
        this.retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientBuilder.build())
            .build()
    }

    fun <T> from(service: Class<T>): T {
        return this.retrofit.create(service) as T
    }
}