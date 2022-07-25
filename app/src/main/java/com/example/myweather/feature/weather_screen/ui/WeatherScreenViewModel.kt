package com.example.myweather.feature.weather_screen.ui

import androidx.lifecycle.ViewModel
import com.example.myweather.base.BaseViewModel
import com.example.myweather.base.Event
import com.example.myweather.feature.weather_screen.WeatherIteractor

class WeatherScreenViewModel(val iteractor: WeatherIteractor): BaseViewModel<ViewState>() {

   suspend fun getWeather(city:String): String{
        return iteractor.getWeather(city)
    }
    suspend fun getWind(city: String): String{
        return iteractor.getWind(city)
    }

    override fun initialViewState(): ViewState = ViewState(temperature = "", wind = "", city ="")


    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {

       when(event){

           is UiEvent.OnButtonClicked -> {
               val city = event.city
              val temperature = getWeather(event.city)
               val wind = getWind(event.city)
               return previousState.copy(temperature = temperature, wind = wind, city = city)

           }

           is DataEvent.WeatherLoaded -> {
               val city = event.city
               val temperature = getWeather(event.city)
               val wind = getWind(event.city)
               return previousState.copy(temperature = temperature, wind = wind, city = city)
           }

           else ->
               return null
       }
    }
}