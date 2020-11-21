package com.yandex.smur.marina.intent_filter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class ShowTimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        val sdf = SimpleDateFormat("HH:mm:ss")
        val time = sdf.format(Date(System.currentTimeMillis()))

        val textViewShowTime = findViewById<TextView>(R.id.textViewTime)
        textViewShowTime.text = time
    }
}