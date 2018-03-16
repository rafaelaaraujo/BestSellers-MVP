package com.bestsellers.favorite

import com.bestsellers.data.BestSellersRepository
import com.bestsellers.data.model.Book

/**
 * Created by rafaela.araujo on 27/02/18.
 */
class FavoritePresenter(
        private val repository: BestSellersRepository) : FavoriteContract.Presenter {

    override lateinit var view: FavoriteContract.View

    override fun getFavoriteBooks() {
        view.showLoading()
        val list = repository.getFavoriteBooks()
        if (list != null && list.isNotEmpty()) {
            view.hideLoading()
            view.showFavoriteBooks(list)
        } else {
            view.showErrorMessage()
        }
    }

    override fun removeFavoriteBook(book: Book) {
        repository.removeFavoriteBook(book)
    }
}