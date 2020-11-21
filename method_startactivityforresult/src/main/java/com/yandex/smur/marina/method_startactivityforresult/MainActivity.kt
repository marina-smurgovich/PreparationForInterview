package com.yandex.smur.marina.method_startactivityforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private final val REQUEST_COLOR = 1
    private final val REQUEST_GRAVITY = 2

    private lateinit var textView : TextView
    private lateinit var buttonColor : Button
    private lateinit var buttonGravity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        buttonColor = findViewById(R.id.buttonColor)
        buttonGravity = findViewById(R.id.buttonGravity)

        buttonColor.setOnClickListener{
            val intent = Intent(this, ColorActivity::class.java)
            startActivityForResult(intent, REQUEST_COLOR)
        }

        buttonGravity.setOnClickListener{
            val intent = Intent(this, GravityActivity::class.java)
            startActivityForResult(intent, REQUEST_GRAVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_COLOR) {
                val color = data!!.getIntExtra("color", 0)
                textView.setTextColor(color)
            }
            if (requestCode == REQUEST_GRAVITY) {
                val gravity = data!!.getIntExtra("gravity", 0)
                textView.gravity = gravity
            }
        }
    }
}
