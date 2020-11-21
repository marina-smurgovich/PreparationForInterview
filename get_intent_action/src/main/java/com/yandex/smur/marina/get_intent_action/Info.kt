package com.yandex.smur.marina.get_intent_action

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class Info : AppCompatActivity() {

    private lateinit var sdf : SimpleDateFormat
    private lateinit var textInfo : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_activity)

        val intent = intent
        val action = intent.action

        if (action.equals("com.yandex.smur.marina.showDate")) {
            sdf = SimpleDateFormat("dd - MM - yyyy")
            textInfo = "Date: "
        }

        if (action.equals("com.yandex.smur.marina.showTime")) {
            sdf = SimpleDateFormat("HH : mm")
            textInfo = "Time: "
        }

        val info = sdf.format(Date(System.currentTimeMillis()))

        val textViewInfo = findViewById<TextView>(R.id.textViewInfo)
        textViewInfo.text = textInfo + info

    }
}