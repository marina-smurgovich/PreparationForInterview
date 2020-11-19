package com.yandex.smur.marina.activity_lifecycler

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {

    private val TAG : String = "Marina"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d(TAG, "SecondActivity / onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SecondActivity / onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SecondActivity / onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SecondActivity / onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SecondActivity / onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SecondActivity / onDestroy")
    }
}