package com.yandex.smur.marina.sqlitedatabase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

public const val NAME_DATABASE = "ContactsDB"
public const val VERSION = 1
public const val NAME_TABLE = "Contacts"

class DBHelper(context: Context) : SQLiteOpenHelper(context, NAME_DATABASE, null, VERSION) {

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE $NAME_TABLE (KEY_ID REAL PRIMARY KEY, KEY_NAME TEXT, KEY_EMAIL TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}