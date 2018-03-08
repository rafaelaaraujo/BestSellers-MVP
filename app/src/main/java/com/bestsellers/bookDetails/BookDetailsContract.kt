package com.bestsellers.bookDetails

import com.bestsellers.common.BaseView
import com.bestsellers.model.Book
import com.bestsellers.model.BookReviewCount

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

        fun updateStatus(isBookFavorite: Boolean)

    }

    interface Presenter {

        /**
         * request book review from server
         * @param isbn from selected book
         */
        fun getBookReviewCount(isbn: String)

        fun verifyIsFavoriteBook(title: String?)

        fun changeBookStatus(book: Book, favorite: Boolean)
    }
}