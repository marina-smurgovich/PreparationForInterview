package com.yandex.smur.marina.sqlitedatabase

import java.io.Serializable
import kotlin.random.Random

class Contact (
    val id : Int,
    val name : String,
    val email : String) : Serializable