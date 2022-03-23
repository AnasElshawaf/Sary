package com.develop.sary.di.module


import com.develop.sary.network.RemoteDataSource
import com.develop.sary.utility.Constants
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AndroidModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(): RemoteDataSource = RemoteDataSource()

    @Provides
    @Singleton
    fun provideHttpLogging(): OkHttpClient {
        return OkHttpClient.Builder().also { client ->
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            client.addNetworkInterceptor(Interceptor { chain ->
                val request: Request =
                    chain.request().newBuilder()
                        .addHeader("Authorization", Constants.HeaderApi.token)
                        .addHeader("Content-Type", Constants.HeaderApi.ContentType)
                        .addHeader("Vary", Constants.HeaderApi.Vary)
                        .addHeader("Device-Type", Constants.HeaderApi.DeviceType)
                        .addHeader("Device-Id", Constants.HeaderApi.DeviceId)
                        .addHeader("App-Version", Constants.HeaderApi.AppVersion)
                        .addHeader("Accept-Language", Constants.HeaderApi.AcceptLanguage)
                        .addHeader("Platform", Constants.HeaderApi.Platform)
                        .build()
                chain.proceed(request)
            })
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))
        }.build()
    }


}
