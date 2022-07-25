package com.example.myweather.feature.weather_screen.ui

import android.icu.text.CaseMap
import com.example.myweather.base.Event

data class ViewState (
    val temperature: String,
    val wind: String,
    val city:String
    )

sealed class UiEvent: Event {
   data class OnButtonClicked (val city: String) : UiEvent()
}

sealed class DataEvent: Event {
    data class WeatherLoaded (val city: String) : DataEvent()
}
