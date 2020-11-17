package com.keep.run.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keep.run.bean.LoadState
import com.keep.run.network.Repository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Creator: xs
 * Date: 2020/11/19
 * Description: _
 */
class MainViewModel : ViewModel() {
    val imageData = MutableLiveData<List<String>>()
    val loadState = MutableLiveData<LoadState>()

    fun getData() {
        viewModelScope.launch(CoroutineExceptionHandler { _, e ->
            loadState.value = LoadState.Fail(e.message ?: "加载失败")
        }) {
            loadState.value = LoadState.Loading()

            val data1 = async { Repository.getImageData() }
            val data2 = async { Repository.getImageData() }
            val data3 = async { Repository.getImageData() }

            imageData.value = listOf(data1.await(), data2.await(), data3.await()).map {
                it.imgurl
            }

            loadState.value = LoadState.Success()
        }

    }
}