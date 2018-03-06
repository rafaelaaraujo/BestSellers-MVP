package com.bestsellers.bookDetails

import com.bestsellers.common.BasePresenter
import com.bestsellers.common.BaseView
import com.bestsellers.model.Book
import com.bestsellers.model.BookReviewCount
import com.bestsellers.model.Isbn

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */
class BookDetailsContract {

    interface View : BaseView<Presenter> {

        /**
         * show review from selected book
         */
        fun loadBookReviewCount(bookReviewCount: BookReviewCount)

        /**
         * show user message that the book has no reviews
         */
        fun showNoReviewsView()

        fun updateStatus(isBookFavorite: Boolean)
    }

    interface Presenter : BasePresenter {

        /**
         * request book review from server
         * @param isbn from selected book
         */
        fun getBookReviewCount(isbn: String)

        fun verifyIsFavoriteBook(title: String?)

        fun changeBookStatus(book: Book, favorite: Boolean)
    }
}