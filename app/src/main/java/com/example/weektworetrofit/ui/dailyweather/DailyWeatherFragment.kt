package com.example.weektworetrofit.ui.dailyweather

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weektworetrofit.R

class DailyWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = DailyWeatherFragment()
    }

    private val weatherAdapter: DailyWeatherAdapter by lazy { DailyWeatherAdapter() }
    private val dailyWeatherRecyclerView: RecyclerView by lazy {
        requireNotNull(view).findViewById<RecyclerView>(R.id.dailyWeatherRecyclerView)
    }
    private val viewModel: DailyWeatherViewModel by lazy { ViewModelProvider(this).get(DailyWeatherViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.daily_weather_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeWeather()
        viewModel.fetchWeather()
    }

    private fun observeWeather() {
        dailyWeatherRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireNotNull(context))
            adapter = weatherAdapter
        }
        viewModel.dailyWeather.observe(this, Observer {
            weatherAdapter.addItems(it)
        })
    }

}