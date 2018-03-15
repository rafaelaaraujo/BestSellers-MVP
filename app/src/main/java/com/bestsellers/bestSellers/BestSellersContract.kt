package com.bestsellers.bestSellers

import com.bestsellers.common.BaseView
import com.bestsellers.data.model.Book

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BestSellersContract {


    interface View : BaseView<Presenter> {

        fun showBestSellers(bestSeller: List<Book>)

        fun changeFavoriteButton(isfavoriteBook: Boolean)

        fun showFavoriteBookMessage()

        fun showRemoveFavoriteBookMessage()
    }

    interface Presenter {

        fun requestBestSellers(name: String)

        fun changeBookStatus(book: Book, favorite: Boolean)

        fun verifyIsFavoriteBook(book: Book)

    }
}