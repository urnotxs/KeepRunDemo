package com.keep.run.network

/**
 * Creator: xs
 * Date: 2020/11/19
 * Description: _
 */
data class ResponseBody<T>(
    val code: Int,
    val msg: String,
    val data: T
)