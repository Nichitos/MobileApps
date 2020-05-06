package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_screen2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Screen2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(null)
        setContentView(R.layout.activity_screen2)

        val time = findViewById<TextView>(R.id.time)

        val quote = findViewById<TextView>(R.id.quote)

        val retrofit = NetworkClient2.getRetrofitClient()

        val quoteAPI: QuoteAPI = retrofit.create<QuoteAPI>(QuoteAPI::class.java)

        val call = quoteAPI.getQuoteOfTheDay("en")

        call.enqueue(object: Callback<QResponseModel> {
            override fun onResponse(call: Call<QResponseModel>?, response: Response<QResponseModel>?) {
                if (response != null) {
                    val current = LocalDateTime.now()
                    val formatter = DateTimeFormatter.ofPattern("HH:mm")
                    val formatted = current.format(formatter)
                    val qResponse: QResponseModel = response!!.body()!!
                    val model = SecondScreenModel(formatted,"Daily quote: " + qResponse.contents.quotes[0].quote)
                    val controller = SecondScreenController(model, time, quote)
                    controller.setQuote()
                    controller.setTime()
                }
            }

            override fun onFailure(call: Call<QResponseModel>?, t: Throwable?) {
                println("Error " + t!!.message)
            }
        })

        var bundle :Bundle ?=intent.extras
        var ss = bundle!!.getString("ss")
        textView3.setText("Good day " + ss + ", what is your focus for today?")

        val editText = findViewById<EditText>(R.id.editText)


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, Screen3::class.java)
            intent.putExtra("task",  editText.text.toString())
            startActivity(intent)
        }

    }
}

