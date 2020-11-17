package com.keep.run.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * Creator: xs
 * Date: 2020/11/19
 * Description: _
 */
object NetworkService {
    private val retrofit = Retrofit.Builder()
        .client(DefaultOkHttpFactory().getClient())
        .baseUrl("https://testservice.boluohuyu.cn/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create<ApiService>()

}