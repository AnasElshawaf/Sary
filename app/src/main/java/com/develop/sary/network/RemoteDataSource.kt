package com.develop.sary.network

import com.develop.sary.app.App
import com.develop.sary.utility.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class RemoteDataSource {

    @Inject
    lateinit var ok: OkHttpClient

    fun <Api> buildApi(api: Class<Api>): Api {
        (App.instance as App).component.inject(this)

        return Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .client(ok)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

}