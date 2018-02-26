package com.bestsellers.model

/**
 * Created by rafaela.araujo on 26/02/18.
 */

data class ReviewCountResult(
        val books: List<BookReviewCount>
)

data class BookReviewCount(
        val id: String,
        val ratings_count: String,
        val reviews_count: String,
        val average_rating: Float)