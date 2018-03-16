package com.bestsellers.base

import com.bestsellers.R

/**
 * Created by Rafaela Araujo
 * on 04/12/2017.
 */

const val NAMES_JSON = "names_list.json"
const val BEST_SELLERS_JSON = "best_sellers_list.json"
const val NO_REVIEW_JSON = "no_reviews.json"
const val REVIEW_JSON = "reviews.json"

const val ID_BOOKS_LIST = R.id.bestSellersList
const val ID_FAVORITE_LIST = R.id.recyclerFavorite
const val FIRST_BOOK_POSITION = 0
const val ITEM_BOOK_POSITION = 0
const val LAST_BOOK_POSITION = 14
const val FIRST_BOOK_TITLE = "THE PEOPLE VS. ALEX CROSS"
const val FIRST_BOOK_DESCRIPTION = "Detective Cross takes on a case even though he has been suspended from the department and taken to federal court to stand trial on murder charges."
const val FIRST_BOOK_AUTHOR = "by James Patterson"

const val LAST_BOOK_TITLE = "LITTLE FIRES EVERYWHERE"
const val LAST_BOOK_DESCRIPTION = "by Celeste Ng"

const val ID_GENRE_LIST = R.id.genreGrid
const val FIRST_ITEM_GENRE = 0
const val LAST_ITEM_GENRE = 14
const val SEARCH_TEXT_GENRE = "Hardcover Advice & Misc."
const val FIRST_ITEM_TEXT_GENRE = "Combined Print & E-Book Fiction"
const val LAST_ITEM_TEXT_GENRE = "Children’s Middle Grade E-Book"

const val URL_BEST_SELLERS = "/svc/books/v3/lists/%7Bdata%7D/Combined%20Print%20and%20E-Book%20Fiction.json"
const val URL_NO_REVIEW_LAST_ITEM = "/svc/books/v3/reviews.json?title=LITTLE%20FIRES%20EVERYWHERE"
const val URL_NO_REVIEW_FIRST_ITEM = "/svc/books/v3/reviews.json?title=THE%20PEOPLE%20VS.%20ALEX%20CROSS"
const val URL_REVIEW_ITEM = "/svc/books/v3/reviews.json?title=IT"
const val FAVORITE_BOOK_MESSAGE = "Favorite book successfully"
const val UNFAVORITE_BOOK_MESSAGE = "Favorite Remove successfully"
