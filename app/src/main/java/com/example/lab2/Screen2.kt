package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        call.enqueue(object: Callback<QResponse> {
            override fun onResponse(call: Call<QResponse>?, response: Response<QResponse>?) {
                if (response != null) {
                    val qResponse: QResponse = response!!.body()!!
                    quote.text = "Daily quote: " + qResponse.contents.quotes[0].quote
                }
            }

            override fun onFailure(call: Call<QResponse>?, t: Throwable?) {
                println("Error " + t!!.message)
            }
        })

        val current = LocalDateTime.now()

        var bundle :Bundle ?=intent.extras
        var ss = bundle!!.getString("ss")
        textView3.setText("Good day " + ss + ", what is your focus for today?")

        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val formatted = current.format(formatter)
        time.setText(formatted.toString())

        val editText = findViewById<EditText>(R.id.editText)


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, Screen3::class.java)
            intent.putExtra("task",  editText.text.toString())
            startActivity(intent)
        }

    }
}

