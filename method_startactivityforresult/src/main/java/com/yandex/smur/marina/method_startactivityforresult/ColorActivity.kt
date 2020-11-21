package com.yandex.smur.marina.method_startactivityforresult

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ColorActivity : AppCompatActivity() {

    private lateinit var buttonRed : Button
    private lateinit var buttonBlue : Button
    private lateinit var buttonGreen : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        buttonRed = findViewById(R.id.ColorRed)
        buttonBlue = findViewById(R.id.ColorBlue)
        buttonGreen = findViewById(R.id.ColorGreen)

        buttonRed.setOnClickListener{
            val intent = Intent()
            intent.putExtra("color", Color.RED)
            setResult(RESULT_OK, intent)
            finish()
        }

        buttonBlue.setOnClickListener{
            val intent = Intent()
            intent.putExtra("color", Color.BLUE)
            setResult(RESULT_OK, intent)
            finish()
        }

        buttonGreen.setOnClickListener{
            val intent = Intent()
            intent.putExtra("color", Color.GREEN)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}