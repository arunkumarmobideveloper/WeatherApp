package com.example.weektworetrofit.ui.dailyweather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weektworetrofit.data.DayForecast
import com.example.weektworetrofit.di.DIManager
import com.example.weektworetrofit.repository.WeatherRepositoryContract
import kotlinx.coroutines.launch

class DailyWeatherViewModel(
    private val weatherRepo: WeatherRepositoryContract = DIManager.weatherRepo
) : ViewModel() {

    private val LAT = 33.7490f
    private val LNG = 84.3880f

    val dailyWeather = MutableLiveData<List<DayForecast>>()

    fun fetchWeather(lat: Float = LAT, lng: Float = LNG) {
        viewModelScope.launch {
            try {
                val forecast = weatherRepo.getWeather(lat, lng)
                dailyWeather.postValue(forecast.dailyForecasts)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}