package com.bestsellers.data.remote

import com.bestsellers.model.BestSellersResult
import com.bestsellers.model.BookGenresResult
import com.bestsellers.model.ReviewsResult
import com.bestsellers.util.URL_NAMES
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */
interface NyApi {

    @GET(URL_NAMES)
    fun getBookGenresList(): Observable<BookGenresResult>

    @GET("/svc/books/v3/lists/{data}/{list}.json")
    fun getBestSellerByNameList(@Path("list") list:String): Observable<BestSellersResult>

}