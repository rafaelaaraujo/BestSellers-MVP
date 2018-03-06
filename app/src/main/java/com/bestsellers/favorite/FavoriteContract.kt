package com.bestsellers.favorite

import com.bestsellers.common.BasePresenter
import com.bestsellers.common.BaseView
import com.bestsellers.model.Book

/**
 * Created by rafaela.araujo on 27/02/18.
 */
class FavoriteContract {

    interface View : BaseView<Presenter> {
        fun showFavoriteBooks(list: List<Book>)
    }

    interface Presenter : BasePresenter {

        fun getFavoriteBooks()

        fun removeFavoriteBook(book: Book)
    }
}