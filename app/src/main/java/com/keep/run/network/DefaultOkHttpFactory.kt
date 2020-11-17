package com.keep.run.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class DefaultOkHttpFactory : OkHttpFactory {
    override fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .sslSocketFactory(SSLFactory.sslContext?.socketFactory, SSLFactory.xtm)
            .hostnameVerifier(SSLFactory.DO_NOT_VERIFY)
            .callTimeout(10000, TimeUnit.MILLISECONDS)
            .readTimeout(20000, TimeUnit.MILLISECONDS)
            .writeTimeout(20000, TimeUnit.MILLISECONDS)
            .build()
    }
}

interface OkHttpFactory {
    fun getClient(): OkHttpClient
}