package com.bestsellers.bestSellers

import com.bestsellers.data.BestSellersRepository
import com.bestsellers.data.model.Book

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */
class BestSellersPresenter(
        val view: BestSellersContract.View,
        private val source: BestSellersRepository) :
        BestSellersContract.Presenter {

    override fun requestBestSellers(name:String) {
        view.showLoading()
        source.getBestSellers(name, {
            view.hideLoading()
            val books = it.results.books

            if(books.isNotEmpty()) {
                view.showBestSellers(books)
            }else{
                view.showErrorMessage()
            }
        }, {
            view.showErrorMessage()
        })
    }

    override fun changeBookStatus(book: Book, favorite: Boolean) {
        if (favorite){
            source.favoriteBook(book)
            view.showFavoriteBookMessage()
        } else {
            source.removeFavoriteBook(book)
            view.showRemoveFavoriteBookMessage()
        }
    }

    override fun verifyIsFavoriteBook(book: Book) {
        val b = source.getBookFavorite(book.title)
        view.changeFavoriteButton(b != null)
    }
}