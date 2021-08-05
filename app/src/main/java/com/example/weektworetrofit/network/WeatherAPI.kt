package com.example.weektworetrofit.network

import com.example.weektworetrofit.data.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("onecall")
    suspend fun getWeatherForecast(@Query("lat") lat: Float, @Query("lon") lon: Float): ForecastResponse
}