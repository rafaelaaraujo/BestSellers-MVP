package com.bestsellers.dao

import android.arch.persistence.room.*
import com.bestsellers.model.Book

/**
 * Created by rafaela.araujo on 01/03/18.
 */
@Dao
interface BookDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    fun insertBook(book: Book)

    @Delete
    fun deleteBook(book: Book)

    @Query("SELECT * FROM Book")
    fun loadAllFavoriteBooks(): List<Book>
}