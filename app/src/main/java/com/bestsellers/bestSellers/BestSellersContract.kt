package com.bestsellers.bestSellers

import com.bestsellers.common.BaseView
import com.bestsellers.model.Book

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BestSellersContract {


    interface View : BaseView<Presenter> {

        /**
         * load list of books by genre
         * @param bestSeller list of books
         */
        fun showBestSellers(bestSeller: List<Book>)

        fun changeFavoriteButton(isfavoriteBook: Boolean)

        fun showFavoriteBookMessage()

        fun showRemoveFavoriteBookMessage()
    }

    interface Presenter {

        /**
         * request list of books by genre
         * @param name of genre selected
         */
        fun requestBestSellers(name: String)

        fun changeBookStatus(book: Book, favorite: Boolean)

        fun verifyIsFavoriteBook(book: Book)

    }
}