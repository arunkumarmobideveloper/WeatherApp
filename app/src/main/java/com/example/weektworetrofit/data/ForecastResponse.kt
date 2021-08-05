package com.example.weektworetrofit.data

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("lat")
    val lat: Float,
    @SerializedName("lon")
    val lon: Float,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int,
    @SerializedName("daily")
    val dailyForecasts: List<DayForecast> = emptyList()
)