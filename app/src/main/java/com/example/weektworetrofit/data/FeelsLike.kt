package com.example.weektworetrofit.data

import com.google.gson.annotations.SerializedName

data class FeelsLike(
    @SerializedName("day")
    val day: Float,
    @SerializedName("night")
    val night: Float,
    @SerializedName("eve")
    val evening: Float,
    @SerializedName("morn")
    val morning: Float
)