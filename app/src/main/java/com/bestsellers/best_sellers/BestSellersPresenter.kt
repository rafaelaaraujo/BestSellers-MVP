package com.bestsellers.best_sellers

import android.util.Log
import com.bestsellers.common.BestSellersManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */
class BestSellersPresenter(
        val view: BestSellersContract.View,
        val manager: BestSellersManager = BestSellersManager()) : BestSellersContract.Presenter {

    init {
        view.presenter = this
        requestBestSellers()
    }

    fun requestBestSellers() {
        manager.getHistoryBestSellers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retreiveBestSellers ->
                            view.showBestSellers(retreiveBestSellers.results)
                        },
                        { e ->
                            Log.e("erro", e.message)
                        }
                )
    }

}