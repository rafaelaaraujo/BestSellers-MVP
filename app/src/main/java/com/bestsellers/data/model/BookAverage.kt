package com.bestsellers.data.model

/**
 * Created by rafaela.araujo on 26/02/18.
 */

data class BookAverage(
        val books: List<Average>
)

data class Average(
        val id: String,
        val average_rating: Float)