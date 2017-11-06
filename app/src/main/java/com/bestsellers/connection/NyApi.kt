package com.bestsellers.connection

import com.bestsellers.model.HistoryBestSellersResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */
class NyApi {

    private val bestSellersApi: BestSellersApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        bestSellersApi = retrofit.create(BestSellersApi::class.java)
    }

    fun getHistoryBestSellers(): Call<HistoryBestSellersResult> {
       return bestSellersApi.getHistoryBestSellers()
    }
}