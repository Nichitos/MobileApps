package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Math.round


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(null)
        setContentView(R.layout.activity_main)

        val retrofit = NetworkClient.getRetrofitClient()

        val weatherAPI: WeatherAPI = retrofit.create<WeatherAPI>(WeatherAPI::class.java)

        val call = weatherAPI.getWeatherByCity(
            "Chisinau,md",
            "16b1b96b3e6057b412ff3436d66dd414"
        )

        val weather = findViewById<TextView>(R.id.weather)

        println(call.request())

        call.enqueue(object: Callback<WResponse> {
            override fun onResponse(call: Call<WResponse>?, response: Response<WResponse>?) {
                if (response != null) {
                        val wResponse: WResponse = response!!.body()!!
                    var temp = round(wResponse.main.temp.toInt() - 273.15)
                    weather.text = "Temp: " + temp + " °C" + "\n " +
                            "Humidity: " + wResponse.main.humidity + " %"
                }
            }

            override fun onFailure(call: Call<WResponse>?, t: Throwable?) {
                println("Error " + t!!.message)
            }
        })

            toSecondScreen.setOnClickListener {
            val intent = Intent(this, Screen2::class.java)

            intent.putExtra("ss",  editText.text.toString())
            startActivity(intent)
        }

    }
}



