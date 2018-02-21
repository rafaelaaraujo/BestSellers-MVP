package com.bestsellers.bookDetails

import com.bestsellers.common.BasePresenter
import com.bestsellers.common.BaseView
import com.bestsellers.model.Genre

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */
open class BookGenresContract {

    interface View : BaseView<Presenter> {

        /**
         * load list with book genres
         * @param genreList
         */
        fun showGenreList(genreList: List<Genre>)
    }


    interface Presenter : BasePresenter {

        /**
         * get genres from server
         */
        fun requestGenreList()
    }
}