package com.bestsellers.favorite

import com.bestsellers.data.BestSellersData
import com.bestsellers.model.Book

/**
 * Created by rafaela.araujo on 27/02/18.
 */
class FavoritePresenter(
        private val favoriteView: FavoriteContract.View,
        private val data: BestSellersData) : FavoriteContract.Presenter {

    override fun getFavoriteBooks() {
        favoriteView.showLoading()
        val list = data.getFavoriteBooks()
        list?.let {
            favoriteView.hideLoading()
            favoriteView.showFavoriteBooks(list)
            return
        }
            favoriteView.showErrorMessage()
    }

    override fun removeFavoriteBook(book: Book) {
        data.removeFavoriteBook(book)
    }
}