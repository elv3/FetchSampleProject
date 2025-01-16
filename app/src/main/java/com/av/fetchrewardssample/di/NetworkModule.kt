package com.av.fetchrewardssample.di

import com.av.fetchrewardssample.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideOkHttpClient() : OkHttpClient {

        val httpClient = OkHttpClient.Builder().apply {
            readTimeout(30L, TimeUnit.SECONDS)
        }

        // Add more interceptors if required, for now just adding body logging
        HttpLoggingInterceptor().let(httpClient::addInterceptor)

        return httpClient.build()
    }

    @Provides
    fun provideGsonConverterFactory() : GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ) : Retrofit = Retrofit.Builder()
        // Setting URL in here, but ideally it should go on a buildconfig or secrets file
        .baseUrl("https://fetch-hiring.s3.amazonaws.com")
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}
