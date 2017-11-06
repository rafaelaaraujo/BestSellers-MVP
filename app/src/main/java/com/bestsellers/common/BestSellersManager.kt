package com.bestsellers.common

import com.bestsellers.connection.NyApi
import com.bestsellers.model.HistoryBestSellersResult
import io.reactivex.Observable

/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */
class BestSellersManager(val nyApi: NyApi = NyApi()){

    fun getHistoryBestSellers(): Observable<HistoryBestSellersResult> {
        return Observable.create { subscriber ->
            val callResponse = nyApi.getHistoryBestSellers()
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