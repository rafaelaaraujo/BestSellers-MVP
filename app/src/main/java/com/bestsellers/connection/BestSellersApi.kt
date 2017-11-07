package com.bestsellers.connection

import com.bestsellers.model.BestSellersResult
import com.bestsellers.model.GenreResult
import com.bestsellers.model.HistoryBestSellersResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */
interface BestSellersApi {

    @GET("/svc/books/v3/lists/best-sellers/history.json")
    fun getHistoryBestSellers(): Call<HistoryBestSellersResult>

    @GET("/svc/books/v3/lists/names.json")
    fun getGenreList(): Call<GenreResult>

    @GET("/svc/books/v3/lists/{date}/{list}.json")
    fun getBestSellerByNameList(@Path("list") list:String ): Call<BestSellersResult>

}