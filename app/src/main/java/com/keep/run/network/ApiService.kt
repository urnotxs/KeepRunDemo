package com.keep.run.network

import com.keep.run.bean.ImageModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Creator: xs
 * Date: 2020/11/19
 * Description: _
 */
interface ApiService {

    @GET("api/test/image")
    suspend fun getImage(): ResponseBody<ImageModel>

}