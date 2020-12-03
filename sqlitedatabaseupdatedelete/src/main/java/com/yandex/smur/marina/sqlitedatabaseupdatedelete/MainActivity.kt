package com.yandex.smur.marina.sqlitedatabaseupdatedelete

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

private const val MY_LOG = "MarinasLogs"
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editTextId: EditText
    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText

    private lateinit var buttonUpdate : Button
    private lateinit var buttonDelete : Button
    private lateinit var buttonAdd : Button
    private lateinit var buttonRead : Button
    private lateinit var buttonClear : Button

    private lateinit var dbHelper: DBHelper
    private lateinit var database: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        editTextId = findViewById(R.id.editTextViewId)
        editTextName = findViewById(R.id.editTextViewName)
        editTextEmail = findViewById(R.id.editTextViewEmail)

        buttonUpdate = findViewById(R.id.buttonUpdate)
        buttonUpdate.setOnClickListener(this)

        buttonDelete = findViewById(R.id.buttonDelete)
        buttonDelete.setOnClickListener(this)

        buttonAdd = findViewById(R.id.buttonAdd)
        buttonAdd.setOnClickListener(this)

        buttonRead = findViewById(R.id.buttonRead)
        buttonRead.setOnClickListener(this)

        buttonClear = findViewById(R.id.buttonClear)
        buttonClear.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        dbHelper = DBHelper(this)
        database = dbHelper.writableDatabase
        val contentValues = ContentValues()

        val id = editTextId.text.toString()
        val name = editTextName.text.toString()
        val email = editTextEmail.text.toString()

       when(view.id) {
           R.id.buttonUpdate -> {
               Log.d(MY_LOG, "------------Update----------------")
            if (id == "") {
                Toast.makeText(this, "Enter id", Toast.LENGTH_SHORT).show()
            } else{
                contentValues.put("key_name", name)
                contentValues.put("key_email", email)
                database.update(TABLE_NAME, contentValues, "KEY_ID = " + id, null)
                Log.d(MY_LOG, "id = $id; name: $name; email: $email")
            }
           }

           R.id.buttonDelete -> {
               Log.d(MY_LOG, "------------Delete----------------")
               if (id == "") {
                   Toast.makeText(this, "Enter id", Toast.LENGTH_SHORT).show()
               } else{
                   database.delete(TABLE_NAME, "KEY_ID = " + id, null)
                   Log.d(MY_LOG, "Delete item id = $id")
               }
           }

           R.id.buttonAdd -> {
               contentValues.put("key_name", name)
               contentValues.put("key_email", email)

               val id = database.insert(TABLE_NAME, null, contentValues)
               Log.d(MY_LOG, "Add to dataBase contact id = $id; name: $name; email: $email")
           }

           R.id.buttonRead -> {
               val cursor = database.query(TABLE_NAME, null, null, null,
                   null, null, null)
               if (cursor.moveToFirst()) {
                   val indexId = cursor.getColumnIndex("KEY_ID")
                   val indexName = cursor.getColumnIndex("KEY_NAME")
                   val indexEmail = cursor.getColumnIndex("KEY_EMAIL")

                   do{
                       Log.d(MY_LOG,"id = ${cursor.getString(indexId)}; name: ${cursor.getString(indexName)}; " +
                               "email: ${cursor.getString(indexEmail)}")
                   } while (cursor.moveToNext())
               }
           }

           R.id.buttonClear -> {
            val countOfDeletedContacts = database.delete(TABLE_NAME, null, null)
               Log.d(MY_LOG, "Deleted $countOfDeletedContacts items")
           }

       }
    }
}
