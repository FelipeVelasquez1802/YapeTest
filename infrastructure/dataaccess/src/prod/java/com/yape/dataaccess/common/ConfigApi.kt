package com.yape.dataaccess.common

import com.yape.dataaccess.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigApi {
    companion object {
        private val interceptor = HttpLoggingInterceptor()
            get() {
                field.level = HttpLoggingInterceptor.Level.BODY
                return field
            }
        private val httpClient = OkHttpClient.Builder()
            get() {
                val buildType = BuildConfig.BUILD_TYPE
                if (buildType == "debug") {
                    field.addInterceptor(interceptor)
                }
                return field
            }
        private val retrofit: Retrofit = Retrofit
            .Builder()
            .baseUrl(BuildConfig.HOSTNAME)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        fun <T> getApi(clazz: Class<T>): T = retrofit.create(clazz)
    }
}