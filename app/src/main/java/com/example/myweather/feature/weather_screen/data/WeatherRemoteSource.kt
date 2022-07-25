package com.example.myweather.feature.weather_screen.data

import com.example.myweather.feature.weather_screen.data.model.WeatherRemoteModel
import retrofit2.Response

class WeatherRemoteSource(private val api: WeatherApi) {

    // TODO add query
   suspend fun getWeather (city:String): WeatherRemoteModel {
        return api.getWeather(query = city)
    }
}