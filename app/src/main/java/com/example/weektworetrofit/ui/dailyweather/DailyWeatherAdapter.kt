package com.example.weektworetrofit.ui.dailyweather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weektworetrofit.R
import com.example.weektworetrofit.data.DayForecast

class DailyWeatherAdapter : RecyclerView.Adapter<DailyWeatherViewHolder>() {

    private val items: MutableList<DayForecast> = mutableListOf()

    fun addItems(items: List<DayForecast>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DailyWeatherViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_weather_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: DailyWeatherViewHolder, position: Int) {
        holder.bindModelToView(items[position])
    }

}