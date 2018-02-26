package com.bestsellers.bookDetails

import com.bestsellers.connection.BestSellersService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BookDetailsPresenter(
        val view: BookDetailsContract.View,
        private val service: BestSellersService = BestSellersService()) :
        BookDetailsContract.Presenter {

    override fun getBookReviewCount(isbn: String) {
        view.showLoading()
        service.getBookReviewsCount(isbn)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retrieveReviews ->
                            if (retrieveReviews != null)
                                view.loadBookReviewCount(retrieveReviews.books[0])
                            else
                                view.showNoReviewsView()
                        },
                        {
                            view.showErrorMessage()
                        }
                )
    }

}