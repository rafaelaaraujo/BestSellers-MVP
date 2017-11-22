package com.bestsellers.bestSellers

import com.bestsellers.connection.BestSellersService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */
class BestSellersPresenter(
        private val view: BestSellersContract.View,
        private val service: BestSellersService = BestSellersService()) :
        BestSellersContract.Presenter {

    init {
        view.presenter = this
    }

    override fun requestBestSellers(name:String) {
        view.showLoading()
        service.getBestSeller(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retreiveBestSellers ->
                            view.hideLoading()
                            view.showBestSellers(retreiveBestSellers.results.books)
                        },
                        {
                            view.showErrorMessage()
                        }
                )
    }

}