package com.yandex.smur.marina.intent_with_data

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var buttonWeb : Button
    private lateinit var buttonMap : Button
    private lateinit var buttonPhone : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonWeb = findViewById(R.id.Web)
        buttonMap = findViewById(R.id.Map)
        buttonPhone = findViewById(R.id.Phone)

        buttonWeb.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse("https://startandroid.ru/ru/uroki/vse-uroki-spiskom/70-urok-31-zachem-u-intent-est-atribut-data-chto-takoe-uri-vyzyvaem-sistemnye-prilozhenija.html")
            startActivity(intent)
        }

        buttonMap.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse("geo:55.754283,37.62002")
            startActivity(intent)
        }

        buttonPhone.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = Uri.parse("tel:80293592389")
            startActivity(intent)
        }
    }
}
