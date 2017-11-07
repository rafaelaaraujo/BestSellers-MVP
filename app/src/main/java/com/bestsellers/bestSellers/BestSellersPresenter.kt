package com.bestsellers.bestSellers

import com.bestsellers.common.BestSellersManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */
class BestSellersPresenter(
        val view: BestSellersContract.View,
        private val manager: BestSellersManager = BestSellersManager()) : BestSellersContract.Presenter {

    init {
        view.presenter = this
    }

    override fun requestBestSellers(name:String) {
        manager.getBestSellerList(name)
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