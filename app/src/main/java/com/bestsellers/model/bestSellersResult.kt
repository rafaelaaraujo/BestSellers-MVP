package com.bestsellers.model

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


data class Book(
        val rank: Int,
        val rank_last_week: Int,
        val weeks_on_list: Int,
        val publisher: String,
        val description: String,
        val price: Float,
        val title: String,
        val author: String,
        val contributor: String,
        val contributor_note: String,
        val book_image: String,
        val amazon_product_url: String,
        val book_review_link: String,
        val first_chapter_link: String
) : Serializable
