package com.example.myweather.feature.weather_screen.data

interface WeatherRepo {

   suspend fun getTemperature(city: String): String

   suspend fun getWind(city: String): String
}