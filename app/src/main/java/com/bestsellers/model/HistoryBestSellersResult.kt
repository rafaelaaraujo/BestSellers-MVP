package com.bestsellers.model

/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */
data class HistoryBestSellersResult(
        val status: String,
        val num_results: Int,
        val results: List<BestSeller>)

data class BestSeller(
        val title: String,
        val description: String,
        val contributor: String,
        val author: String,
        val contributor_note: String,
        val price: Double,
        val age_group: String,
        val publisher: String,
        val reviews: List<HistoryReview>)

data class HistoryReview(
        val book_review_link: String,
        val first_chapter_link: String)
