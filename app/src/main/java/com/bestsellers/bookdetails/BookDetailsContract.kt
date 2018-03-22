package com.bestsellers.bookdetails

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

        fun showUnfavoriteBookMessage()
    }

    interface Presenter : BasePresenter<View>{

        fun getBookAverage(isbn: String)

        fun verifyIsFavoriteBook(title: String?)

        fun changeBookStatus(book: Book, favorite: Boolean)
    }
}