package com.bestsellers.data.model

/**
 * Created by rafaela.araujo on 07/11/17.
 */

data class BookGenres(
        val results: List<Genre>)

data class Genre(
        val list_name: String,
        val display_name: String,
        val updated: String)