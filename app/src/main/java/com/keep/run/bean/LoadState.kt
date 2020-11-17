package com.keep.run.bean

/**
 * Creator: xs
 * Date: 2020/11/19
 * Description: _
 */
sealed class LoadState(val msg: String) {
    class Loading(msg: String = "") : LoadState(msg)
    class Success(msg: String = "") : LoadState(msg)
    class Fail(msg: String) : LoadState(msg)
}