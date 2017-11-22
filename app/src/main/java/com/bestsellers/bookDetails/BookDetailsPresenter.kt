package com.bestsellers.bookDetails

import com.bestsellers.common.BestSellersManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BookDetailsPresenter(
        val view: BookDetailsContract.View,
        private val manager: BestSellersManager = BestSellersManager()) :
        BookDetailsContract.Presenter {

    init {
        view.presenter = this
    }

    override fun getBookReview(tittle: String) {
        view.showLoading()
        manager.getReview(tittle)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retreiveReviews ->
                            if (retreiveReviews.num_results > 0)
                                view.loadBookReview(retreiveReviews.results[0].url)
                            else
                                view.showNoReviewsView()
                        },
                        {
                            view.showErrorMessage()
                        }
                )


    }


}