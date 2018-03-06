package com.bestsellers.data

import android.content.Context
import com.bestsellers.data.local.AppDatabase
import com.bestsellers.data.remote.BestSellersService
import com.bestsellers.model.BestSellersResult
import com.bestsellers.model.Book
import com.bestsellers.model.BookGenresResult
import com.bestsellers.model.ReviewCountResult
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Rafaela Araujo
 * on 05/03/2018.
 */
class BestSellersData(private val service: BestSellersService = BestSellersService(), val context: Context? = null) {

    fun getBookReviewCount(isbn: String, success: (ReviewCountResult) -> Unit, error: () -> Unit) {
        doRequest(service.getBookReviewsCount(isbn), success, error)
    }

    fun getBestSellers(name: String, success: (BestSellersResult) -> Unit, error: () -> Unit) {
        doRequest(service.getBestSeller(name), success, error)
    }

    fun getBestSellersGenre(success: (BookGenresResult) -> Unit, error: () -> Unit) {
        doRequest(service.getGenreList(), success, error)
    }

    fun getFavoriteBooks(): List<Book>? {
        return getFavoriteDao()?.loadAllFavoriteBooks()
    }

    fun removeFavoriteBook(book: Book) {
        getFavoriteDao()?.deleteBook(book)
    }

    fun favoriteBook(book: Book) {
        getFavoriteDao()?.insertBook(book)
    }

    fun getBookFavorite(title:String): Book? {
        return getFavoriteDao()?.getFavoriteBook(title)
    }

    private fun getFavoriteDao() = context?.let { AppDatabase.getInstance(it)?.getFavoriteBookDao() }

    private fun <T> doRequest(observable: Observable<T>, success: (T) -> Unit, error: () -> Unit) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result -> success(result) }, { error() })
    }

}