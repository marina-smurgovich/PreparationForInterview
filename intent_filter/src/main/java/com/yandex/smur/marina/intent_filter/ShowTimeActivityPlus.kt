package com.yandex.smur.marina.intent_filter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class ShowTimeActivityPlus : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_plus)

        val sdf = SimpleDateFormat("HH:mm")
        val time = sdf.format(Date(System.currentTimeMillis()))

        val textViewShowTime = findViewById<TextView>(R.id.textViewTimePlus)
        textViewShowTime.text = time
    }
}