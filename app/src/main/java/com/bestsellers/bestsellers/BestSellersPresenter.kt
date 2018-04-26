package com.bestsellers.bestsellers

import com.bestsellers.data.BestSellersRepository
import com.bestsellers.data.model.Book

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */
class BestSellersPresenter(private val booksGenre: String,
                           private val repository: BestSellersRepository) : BestSellersContract.Presenter {

    override lateinit var view: BestSellersContract.View

    override fun requestBestSellers() {
        view.showLoading()
        repository.getBestSellers(booksGenre, {
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

        if (favorite) {
            repository.addFavoriteBook(book)
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