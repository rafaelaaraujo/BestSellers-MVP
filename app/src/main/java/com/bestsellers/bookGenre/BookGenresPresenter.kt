package com.bestsellers.bookGenre

import com.bestsellers.bookDetails.BookGenresContract
import com.bestsellers.data.BestSellersData


/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BookGenresPresenter(
        val view: BookGenresContract.View,
        private val data: BestSellersData = BestSellersData()) : BookGenresContract.Presenter {

    init {
        view.presenter = this
    }

    override fun requestGenreList() {
        view.showLoading()

        data.getBestSellersGenre({
            view.hideLoading()
            view.showGenreList(it.results)
        }, {
            view.showErrorMessage()
        })

    }
}