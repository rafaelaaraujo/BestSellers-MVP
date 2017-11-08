package com.bestsellers.model

/**
 * Created by rafaela.araujo on 08/11/17.
 */
data class ReviewsResult(
        val status: String,
        val num_results: Int,
        val results: List<BookReview>)

data class BookReview(
        val url: String,
        val publication_dt: String
)