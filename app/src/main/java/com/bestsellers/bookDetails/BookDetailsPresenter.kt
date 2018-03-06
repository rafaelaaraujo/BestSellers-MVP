package com.bestsellers.bookDetails

import com.bestsellers.data.BestSellersData
import com.bestsellers.model.Book
import com.bestsellers.model.BookReviewCount

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BookDetailsPresenter(
        val view: BookDetailsContract.View,
        private val data: BestSellersData) :
        BookDetailsContract.Presenter {

    override fun getBookReviewCount(isbn: String) {
        view.showLoading()
        data.getBookReviewCount(isbn, {
            verifyReview(it.books)
        }, {
            view.showErrorMessage()
        })
    }

    private fun verifyReview(books: List<BookReviewCount>) {
        if (books.isNotEmpty())
            view.loadBookReviewCount(books[0])
        else
            view.showNoReviewsView()
    }

    override fun verifyIsFavoriteBook(title: String?) {
        val b = data.getBookFavorite(title)
        view.updateStatus(b != null)
    }

    override fun changeBookStatus(book: Book, favorite: Boolean) {
        if (favorite) {
            data.favoriteBook(book)
        } else {
            data.removeFavoriteBook(book)
        }

        view.updateStatus(favorite)
    }

}