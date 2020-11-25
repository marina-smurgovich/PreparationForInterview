package com.yandex.smur.marina.sharedpreferencesradiobutton

import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView : TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton
    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        radioGroup.setOnCheckedChangeListener { radioGroup, i -> setColorInTextView() }

        checkBox1.setOnClickListener {
            setTextInTextView1()
        }

        checkBox2.setOnClickListener {
            setTextInTextView2()
        }

        loadPref()
    }

    private fun setTextInTextView1() {
        textView.setText(R.string.hello)
    }

    private fun setTextInTextView2() {
        textView.setText(R.string.hi)
    }

    private fun init() {
        textView = findViewById(R.id.textView)
        radioGroup = findViewById(R.id.radioGroup)
        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)
        radioButton3 = findViewById(R.id.radioButton3)
        checkBox1 = findViewById(R.id.checkbox1)
        checkBox2 = findViewById(R.id.checkbox2)

        checkBox2.isChecked = !checkBox1.isChecked
    }

    override fun onDestroy() {
        super.onDestroy()
        savePref()
    }

    private fun savePref() {
        val shp = getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor : SharedPreferences.Editor = shp.edit()
        editor.putInt("save preferences",
            radioGroup.indexOfChild(findViewById(radioGroup.checkedRadioButtonId)))

        if(checkBox1.isChecked) {
            editor.putInt("save checkbox", R.id.checkbox1)
        } else if(checkBox2.isChecked){
            editor.putInt("save checkbox", R.id.checkbox2)
        }

        editor.apply()
    }

    private fun loadPref() {
        val shp = getSharedPreferences("MyPref", MODE_PRIVATE)
        val id = shp.getInt("save preferences", 0)
        val radioButton : RadioButton = radioGroup.getChildAt(id) as RadioButton
        radioButton.isChecked = true

        val idCheckBox = shp.getInt("save checkbox", 0)
        if (idCheckBox == R.id.checkbox1) {
            checkBox1.isChecked = true
        } else if (idCheckBox == R.id.checkbox2) {
            checkBox1.isChecked = false
        }
    }

    private fun setColorInTextView() {
        when {
            radioButton1.isChecked -> {
                textView.setTextColor(Color.BLUE)
            }
            radioButton2.isChecked -> {
                textView.setTextColor(Color.GREEN)
            }
            radioButton3.isChecked -> {
                textView.setTextColor(Color.MAGENTA)
            }
            else -> {
                textView.setTextColor(Color.YELLOW)
            }
        }
    }


}
