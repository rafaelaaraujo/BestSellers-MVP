package com.bestsellers.data.remote

import com.bestsellers.model.BestSellersResult
import com.bestsellers.model.BookGenresResult
import com.bestsellers.model.ReviewCountResult
import com.bestsellers.util.API_KEY
import com.bestsellers.util.GOODREADS_BASE_URL
import com.bestsellers.util.NY_AUTORIZATION
import com.bestsellers.util.NY_BASE_URL
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by Rafaela Araujo
 * on 06/11/2017.
 */


open class BestSellersService {

    private val nyApi: NyApi
    private val goodReadsApi: GoodReadsApi

    init {
        nyApi = getRetrofit(NY_BASE_URL, NY_AUTORIZATION).create(NyApi::class.java)
        goodReadsApi = getRetrofit(GOODREADS_BASE_URL).create(GoodReadsApi::class.java)
    }

    private fun getRetrofit(baseUrl: String, authorization: String? = null) =
            Retrofit.Builder().apply {
                baseUrl(baseUrl)
                addConverterFactory(MoshiConverterFactory.create())
                addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                if (authorization != null) {
                    client(getOkHttpClient(authorization))
                }
            }.build()


    private fun getOkHttpClient(authorization: String): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder().addHeader(API_KEY, authorization).build()
            chain.proceed(request)
        }.build()
    }

    fun getGenreList(): Observable<BookGenresResult> = nyApi.getBookGenresList()

    fun getBestSeller(name: String): Observable<BestSellersResult> = nyApi.getBestSellerByNameList(name)

    fun getBookReviewsCount(isbn: String): Observable<ReviewCountResult> = goodReadsApi.getBookReviewCount(isbn)
}