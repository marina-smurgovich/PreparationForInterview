package com.yandex.smur.marina.shared_preferences

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var buttonSave : Button
    private lateinit var buttonLoad: Button
    private lateinit var editText: EditText
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSave = findViewById(R.id.buttonSave)
        buttonLoad = findViewById(R.id.buttonLoad)
        editText = findViewById(R.id.edTextView)


        buttonSave.setOnClickListener {
            save()
        }

        buttonLoad.setOnClickListener {
            loadPref()
        }

        loadPref()
    }

    private fun loadPref() {
       sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE)
        val saveText : String = sharedPreferences.getString("save text", "") as String
        editText.setText(saveText)
    }

    private fun save() {
        sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("save text", editText.text.toString())
        editor.apply()
    }

    override fun onStop() {
        super.onStop()
        save()
    }
}
