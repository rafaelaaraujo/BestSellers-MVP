package com.bestsellers.data.local

import android.arch.persistence.room.TypeConverter
import com.bestsellers.data.model.Isbn
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by rafaela.araujo on 01/03/18.
 */
open class Converters {
    @TypeConverter
    fun fromString(value: String): List<Isbn> {
        val listType = object : TypeToken<List<Isbn>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<Isbn>): String {
        return  Gson().toJson(list)
    }
}