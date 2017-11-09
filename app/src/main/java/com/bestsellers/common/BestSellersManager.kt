package com.bestsellers.common

import com.bestsellers.connection.BestSellersService
import com.bestsellers.model.BestSellersResult
import com.bestsellers.model.GenreResult
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
        val callResponse = bestSellersService.getHistoryBestSellers()
        return getObservable(callResponse)
    }

    fun getGenreList(): Observable<GenreResult> {
        val callResponse = bestSellersService.getGenreList()
        return getObservable(callResponse)
    }

    fun getBestSellerList(listName: String): Observable<BestSellersResult> {
        val callResponse = bestSellersService.getBestSellerByNameList(listName)
        return getObservable(callResponse)
    }

    fun getReview(tittle: String): Observable<ReviewsResult> {
        val callResponse = bestSellersService.getReviews(tittle)
        return getObservable(callResponse)
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