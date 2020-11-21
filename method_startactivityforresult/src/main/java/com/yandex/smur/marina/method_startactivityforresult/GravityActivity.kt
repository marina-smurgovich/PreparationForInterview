package com.yandex.smur.marina.method_startactivityforresult

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GravityActivity : AppCompatActivity() {

    private lateinit var buttonCenter : Button
    private lateinit var buttonLeft : Button
    private lateinit var buttonRight : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gravity)

        buttonCenter = findViewById(R.id.GravityCenter)
        buttonLeft = findViewById(R.id.GravityLeft)
        buttonRight = findViewById(R.id.GravityRight)

        buttonCenter.setOnClickListener{
            val intent = Intent()
            intent.putExtra("gravity", Gravity.CENTER)
            setResult(RESULT_OK, intent)
            finish()
        }

        buttonLeft.setOnClickListener{
            val intent = Intent()
            intent.putExtra("gravity", Gravity.LEFT)
            setResult(RESULT_OK, intent)
            finish()
        }

        buttonRight.setOnClickListener{
            val intent = Intent()
            intent.putExtra("gravity", Gravity.RIGHT)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}