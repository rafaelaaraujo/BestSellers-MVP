package com.bestsellers.bookDetails

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BestSellerDetailsPresenter(val bestSellerView: BestSellerDetailsContract.View): BestSellerDetailsContract.Presenter {

    init {
        bestSellerView.presenter = this
    }
}