package com.bestsellers.bestSellers

import com.bestsellers.data.BestSellersRepository
import com.bestsellers.data.model.Book

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */
class BestSellersPresenter(private val repository: BestSellersRepository) : BestSellersContract.Presenter {

    override lateinit var view: BestSellersContract.View

    override fun requestBestSellers(name: String) {
        view.showLoading()
        repository.getBestSellers(name, {
            view.hideLoading()
            val books = it.results.books
            if (books.isNotEmpty()) {
                view.showBestSellers(books)
            } else {
                view.showErrorMessage()
            }

        }, {
            view.showErrorMessage()
        })

    }

    override fun changeBookStatus(book: Book, favorite: Boolean) {

        if (favorite){
            repository.favoriteBook(book)
            view.showFavoriteBookMessage()
        } else {
            repository.removeFavoriteBook(book)
            view.showRemoveFavoriteBookMessage()
        }
    }

    override fun verifyIsFavoriteBook(book: Book) {
        val b = repository.getBookFavorite(book.title)
        view.changeFavoriteButton(b != null)
    }
}