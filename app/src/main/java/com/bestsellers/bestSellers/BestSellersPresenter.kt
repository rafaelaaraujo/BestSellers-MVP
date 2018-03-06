package com.bestsellers.bestSellers

import com.bestsellers.data.BestSellersData
import com.bestsellers.model.Book

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */
class BestSellersPresenter(
        val view: BestSellersContract.View,
        private val data: BestSellersData) :
        BestSellersContract.Presenter {

    override fun requestBestSellers(name:String) {
        view.showLoading()
        data.getBestSellers(name, {
            view.hideLoading()
            view.showBestSellers(it.results.books)
        }, {
            view.showErrorMessage()
        })
    }

    override fun saveBookfavorite(book: Book){
        data.favoriteBook(book)
    }
}