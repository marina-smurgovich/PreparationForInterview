package com.yandex.smur.marina.activity_lifecycler

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG : String = "Marina"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity / onCreate")

        button.setOnClickListener {
            val intent = Intent (this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity / onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity / onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity / onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity / onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity / onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MainActivity / onRestart")
    }
}
