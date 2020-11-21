package com.yandex.smur.marina.intent_filter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var buttonShowDate : Button
    private lateinit var buttonShowTime : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonShowDate = findViewById(R.id.buttonShowDate)
        buttonShowTime = findViewById(R.id.buttonShowTime)

        buttonShowDate.setOnClickListener {
            val intent = Intent ("com.yandex.smur.marina.showDate")
            startActivity(intent)
        }

        buttonShowTime.setOnClickListener{
            val intent = Intent("com.yandex.smur.marina.showTime")
            startActivity(intent)
        }
    }
}
