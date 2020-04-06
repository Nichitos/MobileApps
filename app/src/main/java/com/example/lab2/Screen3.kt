package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_screen3.*

class Screen3 : AppCompatActivity() {

    val tasks : ArrayList<Task> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen3)

        var strUser: String? = intent.getStringExtra("task")

        val addButton = findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener{
            tasks.add(Task("New task", false))
            recycler.adapter!!.notifyDataSetChanged()
        }

        tasks.add(Task(strUser.toString(), false))

        recycler.layoutManager = LinearLayoutManager(this)

        recycler.adapter = TaskAdapter(tasks)

    }
}
