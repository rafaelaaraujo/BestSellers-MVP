package com.bestsellers.bookgenre

import com.bestsellers.bookdetails.BookGenresContract
import com.bestsellers.data.BestSellersRepository


/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BookGenresPresenter(private val source: BestSellersRepository) : BookGenresContract.Presenter {

    override lateinit var view: BookGenresContract.View

    override fun requestGenreList() {
        view.showLoading()

        source.getBestSellersGenre({
            view.hideLoading()
            val genres = it.results
            if (genres.isNotEmpty()) {
                view.showGenreList(it.results)
            } else {
                view.showErrorMessage()
            }
        }, {
            view.showErrorMessage()
        })

    }
}