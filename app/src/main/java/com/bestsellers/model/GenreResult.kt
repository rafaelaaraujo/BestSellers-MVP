package com.bestsellers.model

/**
 * Created by rafaela.araujo on 07/11/17.
 */

data class GenreResult(
        val status: String,
        val num_results: Int,
        val results: List<Genre>)

data class Genre(
        val list_name: String,
        val display_name: String,
        val list_name_encoded: String,
        val oldest_published_date: String,
        val newest_published_date: String,
        val teste: String,
        val updated: String)