package com.keep.run.network

import com.keep.run.bean.ImageModel

/**
 * Creator: xs
 * Date: 2020/11/19
 * Description: _
 */
object Repository {

    private fun <T> preProcessData(responseBody: ResponseBody<T>): T {
        return if (responseBody.code == 200) responseBody.data else throw Throwable(responseBody.msg)
    }

    suspend fun getImageData(): ImageModel {
        val responseBody = NetworkService.apiService.getImage()
        return preProcessData(responseBody)
    }
}