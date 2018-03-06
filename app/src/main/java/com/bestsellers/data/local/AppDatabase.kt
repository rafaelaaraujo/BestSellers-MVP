package com.bestsellers.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.bestsellers.model.Book

/**
 * Created by rafaela.araujo on 01/03/18.
 */

@Database(entities = arrayOf(Book::class), version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getFavoriteBookDao(): FavoriteBookDao

    companion object {
        private var instance: AppDatabase? = null
        private val DB_NAME = "book.db"

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, DB_NAME)
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance
        }
    }
}