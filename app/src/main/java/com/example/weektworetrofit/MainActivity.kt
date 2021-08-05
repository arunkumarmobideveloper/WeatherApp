package com.example.weektworetrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weektworetrofit.ui.dailyweather.DailyWeatherFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.apply {
                beginTransaction()
                    .add(R.id.frameLayout, DailyWeatherFragment.newInstance())
                    .commit()
            }
        }
    }

}