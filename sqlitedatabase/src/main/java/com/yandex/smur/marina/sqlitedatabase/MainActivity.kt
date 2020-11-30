package com.yandex.smur.marina.sqlitedatabase

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText

    private lateinit var buttonAdd: Button
    private lateinit var buttonRead: Button
    private lateinit var buttonClear: Button
    private val dbHelper: DBHelper = DBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        editTextName = findViewById(R.id.editTextViewName)
        editTextEmail = findViewById(R.id.editTextViewEmail)

        buttonAdd = findViewById(R.id.buttonAddToDataBase)
        buttonAdd.setOnClickListener(this)

        buttonRead = findViewById(R.id.buttonReadFromDataBase)
        buttonRead.setOnClickListener(this)

        buttonClear = findViewById(R.id.buttonClearDataBase)
        buttonClear.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        val nameStr: String = editTextName.text.toString()
        val emailStr: String = editTextEmail.text.toString()

        val contact: Contact = Contact(Random.nextInt(), nameStr, emailStr)

        val dataBase: SQLiteDatabase = dbHelper.writableDatabase

        when (view.id) {
            R.id.buttonAddToDataBase -> {
                val contentValues: ContentValues = ContentValues().apply {
                    put("KEY_ID", contact.id)
                    put("KEY_NAME", contact.name)
                    put("KEY_EMAIL", contact.email)
                }

                dataBase.insert(NAME_TABLE, null, contentValues)
                Log.d("MarinaLogs", "add to dataBase contact - id = $contact.id, name - " +
                        "${contact.name}, email - ${contact.email}")
            }

            R.id.buttonReadFromDataBase -> {
                val cursor: Cursor = dataBase.query(NAME_TABLE, null, null,
                    null, null, null, null)
                if (cursor.moveToFirst()) {
                    val idIndex: Int = cursor.getColumnIndex("KEY_ID")
                    val nameIndex: Int = cursor.getColumnIndex("KEY_NAME")
                    val emailIndex: Int = cursor.getColumnIndex("KEY_EMAIL")
                    do {
                        Log.d(
                            "MarinaLogs",
                            "id = ${cursor.getInt(idIndex)}, name = ${cursor.getString(nameIndex)}, " +
                                    "email = ${cursor.getString(emailIndex)}"
                        )
                    } while (cursor.moveToNext())
                }

                cursor.close()
            }

            R.id.buttonClearDataBase -> {
                val clearCount = dataBase.delete(NAME_TABLE, null, null)
                Log.d("MarinaLogs", "clear DB, deleted $clearCount contacts")
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelper.close()
    }
}
