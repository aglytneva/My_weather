package com.example.myweather.feature.weather_screen

import com.example.myweather.feature.weather_screen.data.WeatherRepo

class WeatherIteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(city:String): String{
        return weatherRepo.getTemperature(city=city)
    }
    suspend fun getWind(city:String): String{
        return weatherRepo.getWind(city=city)
    }
}