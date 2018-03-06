package com.bestsellers.data.remote

import com.bestsellers.model.ReviewCountResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by rafaela.araujo on 26/02/18.
 */
interface GoodReadsApi {

    @GET("/book/review_counts.json")
    fun getBookReviewCount(@Query("isbns") isbns: String, @Query("key") key: String = "Z0ERaQrt6JugORS6TpPw"): Observable<ReviewCountResult>

}