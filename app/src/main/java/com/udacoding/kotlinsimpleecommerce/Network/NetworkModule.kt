package com.udacoding.kotlinsimpleecommerce.Network

import com.udacoding.kotlinsimpleecommerce.Utils.Constan
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {

    fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(10, TimeUnit.SECONDS) // connect timeout
            .writeTimeout(10, TimeUnit.SECONDS) // write timeout
            .readTimeout(10, TimeUnit.SECONDS)
            .build()

        return client
    }

    fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl(Constan.BASE_URL)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit
    }

    fun getService(): ApiService = getRetrofit().create(ApiService::class.java)

}