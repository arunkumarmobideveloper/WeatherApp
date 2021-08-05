package com.example.weektworetrofit.di

import com.example.weektworetrofit.network.WeatherAPI
import com.example.weektworetrofit.repository.WeatherRepository
import com.example.weektworetrofit.repository.WeatherRepositoryContract
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DIManager {

    private const val API_KEY = "bb5f813e33b83300d9f480de5351d94b"
    private const val API_URL = "https://api.openweathermap.org/data/2.5/"

    val httpLoggingInterceptor: Interceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    val apiKeyInterceptor: Interceptor by lazy {
        Interceptor {
            val original: Request = it.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("appid", API_KEY)
                .build()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            it.proceed(request)
        }
    }

    val weatherApi: WeatherAPI by lazy {
        Retrofit.Builder()
            .client(OkHttpClient.Builder().apply {
                addNetworkInterceptor(apiKeyInterceptor)
                addInterceptor(httpLoggingInterceptor)
            }.build())
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherAPI::class.java)
    }

    val weatherRepo: WeatherRepositoryContract by lazy {
        WeatherRepository(weatherApi)
    }

}