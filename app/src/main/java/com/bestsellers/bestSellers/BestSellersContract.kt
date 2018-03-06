package com.bestsellers.bestSellers

import com.bestsellers.common.BasePresenter
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


    }

    interface Presenter : BasePresenter {

        /**
         * request list of books by genre
         * @param name of genre selected
         */
        fun requestBestSellers(name: String)

        fun saveBookfavorite(book: Book)

    }
}