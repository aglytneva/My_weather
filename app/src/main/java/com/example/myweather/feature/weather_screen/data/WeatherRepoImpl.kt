package com.example.myweather.feature.weather_screen.data

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {

    override suspend fun getTemperature(city: String): String {
        return weatherRemoteSource.getWeather(city=city).main.temperature
    }
    override suspend fun getWind(city: String): String {
        return weatherRemoteSource.getWeather(city = city).wind.windDeg
    }
}