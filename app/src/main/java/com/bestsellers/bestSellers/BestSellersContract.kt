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

        fun showBestSellers(bestSeller: List<Book>)

    }

    interface Presenter : BasePresenter {

        fun requestBestSellers(name: String)

    }
}