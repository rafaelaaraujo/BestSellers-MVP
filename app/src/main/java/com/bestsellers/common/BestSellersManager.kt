package com.bestsellers.common

import com.bestsellers.connection.BestSellersService
import com.bestsellers.model.BestSellersResult
import com.bestsellers.model.GenreResult
import com.bestsellers.model.HistoryBestSellersResult
import io.reactivex.Observable

/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */
class BestSellersManager(val bestSellersService: BestSellersService = BestSellersService()){

    fun getHistoryBestSellers(): Observable<HistoryBestSellersResult> {
        return Observable.create { subscriber ->
            val callResponse = bestSellersService.getHistoryBestSellers()
            val response = callResponse.execute()

            if (response.isSuccessful) {
                subscriber.onNext(response.body())
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    fun getGenreList(): Observable<GenreResult> {
        return Observable.create { subscriber ->
            val callResponse = bestSellersService.getGenreList()
            val response = callResponse.execute()

            if (response.isSuccessful && response.body()?.status == "OK") {
                subscriber.onNext(response.body())
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    fun getBestSellerList(listName:String): Observable<BestSellersResult> {
        return Observable.create { subscriber ->
            val callResponse = bestSellersService.getBestSellerByNameList(listName)
            val response = callResponse.execute()

            if (response.isSuccessful && response.body()?.status == "OK") {
                subscriber.onNext(response.body())
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}