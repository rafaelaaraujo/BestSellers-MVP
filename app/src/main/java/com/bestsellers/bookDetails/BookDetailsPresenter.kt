package com.bestsellers.bookDetails

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BookDetailsPresenter(val bestSellerView: BookDetailsContract.View): BookDetailsContract.Presenter {

    init {
        bestSellerView.presenter = this
    }
}