package com.yandex.smur.marina.intent_filter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class ShowDateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        val sdf = SimpleDateFormat("dd.MM.yyyy")
        val date = sdf.format(Date(System.currentTimeMillis()))

        val textViewShowDate = findViewById<TextView>(R.id.textViewDate)
        textViewShowDate.text = date
    }
}