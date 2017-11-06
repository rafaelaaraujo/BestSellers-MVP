package com.bestsellers.connection

import com.bestsellers.model.HistoryBestSellersResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */
interface BestSellersApi {

    @Headers("api-key: f60617ae371d44d898018a1e77a89a8d")
    @GET("/svc/books/v3/lists/best-sellers/history.json")
    fun getHistoryBestSellers(): Call<HistoryBestSellersResult>

}