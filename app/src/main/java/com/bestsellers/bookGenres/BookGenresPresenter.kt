package com.bestsellers.bookGenres

import com.bestsellers.bookDetails.BookGenresContract
import com.bestsellers.connection.BestSellersService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BookGenresPresenter(
        val view: BookGenresContract.View,
        private val service: BestSellersService = BestSellersService()) : BookGenresContract.Presenter {

    init {
        view.presenter = this
    }

    override fun requestGenreList() {
        view.showLoading()
        service.getGenreList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retreiveGenres ->
                            view.showGenreList(retreiveGenres.results)
                        },
                        {
                            view.showErrorMessage()
                        }
                )
    }
}