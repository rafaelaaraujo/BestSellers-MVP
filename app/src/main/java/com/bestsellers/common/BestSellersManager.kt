package com.bestsellers.common

import com.bestsellers.connection.BestSellersService
import com.bestsellers.model.BestSellersResult
import com.bestsellers.model.BookGenresResult
import com.bestsellers.model.HistoryBestSellersResult
import com.bestsellers.model.ReviewsResult
import io.reactivex.Observable
import retrofit2.Call

/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */
class BestSellersManager(private val bestSellersService: BestSellersService = BestSellersService()) {

    fun getHistoryBestSellers(): Observable<HistoryBestSellersResult> {
        return getObservable(bestSellersService.getHistoryBestSellers())
    }

    fun getGenreList(): Observable<BookGenresResult> {
        return getObservable(bestSellersService.getGenreList())
    }

    fun getBestSellerList(listName: String): Observable<BestSellersResult> {
        return getObservable(bestSellersService.getBestSellerByNameList(listName))
    }

    fun getReview(tittle: String): Observable<ReviewsResult> {
        return getObservable(bestSellersService.getReviews(tittle))
    }

    fun <T : Any> getObservable(callResponse: Call<T>): Observable<T> {
        return Observable.create { subscriber ->
            val response = callResponse.execute()

            if (response.isSuccessful) {
                subscriber.onNext(response.body())
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}