package com.bestsellers.genre

import com.bestsellers.bookDetails.GenreContract
import com.bestsellers.common.BestSellersManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class GenrePresenter(
        val view: GenreContract.View,
        private val manager: BestSellersManager = BestSellersManager()) : GenreContract.Presenter {

    init {
        view.presenter = this
        requestGenreList()
    }

    fun requestGenreList() {
        view.showLoading()
        manager.getGenreList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retreiveGenres ->
                            view.showGenreList(retreiveGenres.results)
                        },
                        { e ->
                            view.showErrorMessage()
                        }
                )
    }
}