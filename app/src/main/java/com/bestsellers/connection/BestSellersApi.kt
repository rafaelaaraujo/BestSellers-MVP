package com.bestsellers.connection

import com.bestsellers.model.BestSellersResult
import com.bestsellers.model.BookGenresResult
import com.bestsellers.model.HistoryBestSellersResult
import com.bestsellers.model.ReviewsResult
import com.bestsellers.util.URL_BEST_SELLERS
import com.bestsellers.util.URL_HISTORY
import com.bestsellers.util.URL_NAMES
import com.bestsellers.util.URL_REVIEWS
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */
interface BestSellersApi {

    @GET(URL_HISTORY)
    fun getHistoryBestSellers(): Observable<HistoryBestSellersResult>

    @GET(URL_NAMES)
    fun getBookGenresList(): Observable<BookGenresResult>

    @GET(URL_BEST_SELLERS)
    fun getBestSellerByNameList(@Path("list") list:String ): Observable<BestSellersResult>

    @GET(URL_REVIEWS)
    fun getReviews(@Query("title") tittle:String ): Observable<ReviewsResult>

}