package com.keep.run.network

import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object SSLFactory {
    var xtm: X509TrustManager
    var DO_NOT_VERIFY: HostnameVerifier
    var sslContext: SSLContext? = null

    init {
        xtm = object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}
            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        }
        try {
            sslContext = SSLContext.getInstance("SSL")

            sslContext?.init(null, arrayOf<TrustManager?>(xtm), SecureRandom())
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: KeyManagementException) {
            e.printStackTrace()
        }
        DO_NOT_VERIFY = HostnameVerifier { hostname, session -> true }
    }
}