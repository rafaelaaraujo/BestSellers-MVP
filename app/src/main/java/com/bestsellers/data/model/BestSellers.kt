package com.bestsellers.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import java.io.Serializable

/**
 * Created by rafaela.araujo on 07/11/17.
 */
data class BestSellers(val results: Results)

data class Results(val books: List<Book>)

@Entity
data class Book(
        @PrimaryKey
        @NonNull
        var title: String = "",
        var rank: Int = 0,
        var weeks_on_list: Int = 0,
        var publisher: String = "",
        var description: String = "",
        var contributor: String = "",
        var book_image: String = "",
        var amazon_product_url: String = "",
        var isbns: List<Isbn> = ArrayList()
) : Serializable

data class Isbn(
        @PrimaryKey
        val isbn10: String,
        val isbn13: String
) : Serializable

