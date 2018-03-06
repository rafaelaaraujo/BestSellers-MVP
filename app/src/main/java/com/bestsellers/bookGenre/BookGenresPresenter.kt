package com.bestsellers.bookGenre

import com.bestsellers.bookDetails.BookGenresContract
import com.bestsellers.data.BestSellersData
import com.bestsellers.data.remote.BestSellersService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BookGenresPresenter(
        val view: BookGenresContract.View,
        private val data: BestSellersData = BestSellersData()) : BookGenresContract.Presenter {

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