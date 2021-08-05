package com.example.weektworetrofit.data

import com.google.gson.annotations.SerializedName

data class DayForecast(
    @SerializedName("dt")
    val dateTime: Long,
    @SerializedName("sunrise")
    val sunrise: Long,
    @SerializedName("sunset")
    val sunset: Long,
    @SerializedName("temp")
    val temperature: Temperature? = null,
    @SerializedName("feels_like")
    val feelsLike: FeelsLike? = null,
    val pressure: Int,
    val humidity: Int,
    @SerializedName("dew_point")
    val dewPoint: Float,
    @SerializedName("wind_speed")
    val windSpeed: Float,
    @SerializedName("wind_deg")
    val windDeg: Int,
    @SerializedName("weather")
    val weatherData: List<Weather>,
    val clouds: Int,
    val pop: Float,
    val uvi: Float
)