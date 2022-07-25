package com.example.myweather

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myweather.feature.weather_screen.ui.DataEvent
import com.example.myweather.feature.weather_screen.ui.ViewState
import com.example.myweather.feature.weather_screen.ui.WeatherScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val btnField: Button by lazy { findViewById(R.id.btnField) }
    private val search: EditText by lazy { findViewById(R.id.Search) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       btnField.setOnClickListener() {
           val city = search.getText().toString()
           val intent = Intent(this, WeatherActivity::class.java)
           Intent(intent)
           intent.putExtra("city", city)
           startActivity(intent);
        }
    }
}