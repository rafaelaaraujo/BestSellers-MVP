package com.bestsellers.bookDetails

import com.bestsellers.data.BestSellersRepository
import com.bestsellers.data.model.Book

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BookDetailsPresenter(private val repository: BestSellersRepository) : BookDetailsContract.Presenter {

    override lateinit var view: BookDetailsContract.View

    override fun getBookReviewCount(isbn: String) {
        view.showLoading()
        repository.getBookAverage(isbn, {
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
        val b = repository.getBookFavorite(title)
        view.updateStatus(b != null)
    }

    override fun changeBookStatus(book: Book, favorite: Boolean) {
        if (favorite) {
            repository.favoriteBook(book)
            view.showFavoriteMessage()
        } else {
            repository.removeFavoriteBook(book)
            view.showRemoveFavoriteBookMessage()
        }

        view.updateStatus(favorite)
    }

}