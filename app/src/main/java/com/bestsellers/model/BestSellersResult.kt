package com.bestsellers.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.content.Context
import android.support.annotation.NonNull
import com.bestsellers.R
import kotlinx.android.synthetic.main.details_activity.*
import java.io.Serializable

/**
 * Created by rafaela.araujo on 07/11/17.
 */
data class BestSellersResult(
        val status: String,
        val num_results: Int,
        val results: Results)

data class Results(
        val list_name: String,
        val list_name_encoded: String,
        val bestsellers_date: String,
        val display_name: String,
        val published_date: String,
        val updated: String,
        val books: List<Book>)

@Entity
data class Book(
        @PrimaryKey
        @NonNull
        var title: String = "",
        var rank: Int = 0,
        var rank_last_week: Int = 0,
        var weeks_on_list: Int = 0,
        var publisher: String = "",
        var published_date: String = "",
        var description: String = "",
        var price: Float = 0f,
        var author: String = "",
        var contributor: String = "",
        var contributor_note: String = "",
        var book_image: String = "",
        var amazon_product_url: String = "",
        var book_review_link: String = "",
        var first_chapter_link: String = "",
        var isbns: List<Isbn> = ArrayList()
) : Serializable

data class Isbn(
        @PrimaryKey
        val isbn10: String,
        val isbn13: String
) : Serializable

