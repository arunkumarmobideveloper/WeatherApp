package com.example.weektworetrofit.ui.dailyweather

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weektworetrofit.R
import com.example.weektworetrofit.data.DayForecast

class DailyWeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val title: TextView by lazy { view.findViewById<TextView>(R.id.titleTextView) }

    fun bindModelToView(model: DayForecast) {
        if (model.weatherData.isNotEmpty()) {
            title.text = model.weatherData.first().description
        }
    }

}