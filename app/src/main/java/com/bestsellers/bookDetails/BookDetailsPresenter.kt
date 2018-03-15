package com.bestsellers.bookDetails

import com.bestsellers.data.BestSellersRepository
import com.bestsellers.data.model.Book

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BookDetailsPresenter(
        val view: BookDetailsContract.View,
        private val source: BestSellersRepository) :
        BookDetailsContract.Presenter {

    override fun getBookReviewCount(isbn: String) {
        view.showLoading()
        source.getBookAverage(isbn, {
            val averageList = it.books
            if(averageList.isNotEmpty()){
                view.loadBookReviewCount(averageList[0])
            } else{
                view.showErrorMessage()
            }
        }, {
            view.showErrorMessage()
        })
    }

    override fun verifyIsFavoriteBook(title: String?) {
        val b = source.getBookFavorite(title)
        view.updateStatus(b != null)
    }

    override fun changeBookStatus(book: Book, favorite: Boolean) {
        if (favorite) {
            source.favoriteBook(book)
            view.showFavoriteMessage()
        } else {
            source.removeFavoriteBook(book)
            view.showRemoveFavoriteBookMessage()
        }

        view.updateStatus(favorite)
    }

}