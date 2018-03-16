package com.bestsellers.bookDetails

import com.bestsellers.common.BasePresenter
import com.bestsellers.common.BaseView
import com.bestsellers.data.model.Book
import com.bestsellers.data.model.Average

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */
class BookDetailsContract {

    interface View : BaseView<Presenter> {

        fun loadBookReviewCount(average: Average)

        fun updateStatus(isBookFavorite: Boolean)

        fun showFavoriteMessage()

        fun showRemoveFavoriteBookMessage()
    }

    interface Presenter : BasePresenter<View>{

        fun getBookReviewCount(isbn: String)

        fun verifyIsFavoriteBook(title: String?)

        fun changeBookStatus(book: Book, favorite: Boolean)
    }
}