package com.example.weektworetrofit.repository

import com.example.weektworetrofit.data.ForecastResponse
import com.example.weektworetrofit.network.WeatherAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface WeatherRepositoryContract {

    suspend fun getWeather(lat: Float, lon: Float): ForecastResponse
}

class WeatherRepository(
    private val weatherAPI: WeatherAPI,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : WeatherRepositoryContract {

    override suspend fun getWeather(lat: Float, lon: Float): ForecastResponse {
        return withContext(dispatcher) {
            weatherAPI.getWeatherForecast(lat, lon)
        }
    }

}