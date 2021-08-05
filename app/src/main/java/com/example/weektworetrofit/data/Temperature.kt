package com.example.weektworetrofit.data

import com.google.gson.annotations.SerializedName

data class Temperature(
    val day: Float,
    val min: Float,
    val max: Float,
    val night: Float,
    @SerializedName("eve")
    val evening: Float,
    @SerializedName("morn")
    val morning: Float
)

