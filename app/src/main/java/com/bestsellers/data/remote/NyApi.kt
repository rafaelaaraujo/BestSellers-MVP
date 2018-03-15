package com.bestsellers.data.remote

import com.bestsellers.data.model.BestSellers
import com.bestsellers.data.model.BookGenres
import com.bestsellers.util.URL_NAMES
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */
interface NyApi {

    @GET(URL_NAMES)
    fun getBookGenresList(): Observable<BookGenres>

    @GET("/svc/books/v3/lists/{data}/{list}.json")
    fun getBestSellerByNameList(@Path("list") list:String): Observable<BestSellers>

}