package com.example.myweather.feature.weather_screen.di

import com.example.myweather.BASE_URL
import com.example.myweather.feature.weather_screen.data.*
import com.example.myweather.feature.weather_screen.WeatherIteractor
import com.example.myweather.feature.weather_screen.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherScreenModule = module {

//     presenter = WeatherScreenPresenter(
//        WeatherIteractor(
//            WeatherRepoImpl(
//                WeatherRemoteSource(WeatherApiClient.getApi())
//            )
//        )
//    )
    single<OkHttpClient> { OkHttpClient.
    Builder().
    build()
    }

    single<Retrofit> {  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(get<OkHttpClient>())
        .build()
    }

    single<WeatherApi > { get<Retrofit>().create(WeatherApi::class.java) }

    single { WeatherRemoteSource(get<WeatherApi>()) }

    single<WeatherRepo> { WeatherRepoImpl(get<WeatherRemoteSource>()) }

    single { WeatherIteractor(get<WeatherRepo>()) }

    viewModel { WeatherScreenViewModel(get<WeatherIteractor>()) }
}


