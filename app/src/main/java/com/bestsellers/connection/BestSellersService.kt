package com.bestsellers.connection

import com.bestsellers.model.*
import com.bestsellers.util.*
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

    private fun getRetrofit(baseUrl: String, autorization: String? = null): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        if (autorization != null) {
            val defaultHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request().newBuilder().addHeader(API_KEY, autorization).build()
                chain.proceed(request)
            }.build()

            retrofit.client(defaultHttpClient)
        }

        return  retrofit.build()
    }

    fun getGenreList(): Observable<BookGenresResult> = nyApi.getBookGenresList()

    fun getBestSeller(name: String): Observable<BestSellersResult> = nyApi.getBestSellerByNameList(name)

    fun getBookReview(tittle: String): Observable<ReviewsResult> = nyApi.getReviews(tittle)

    fun getBookReviewsCount(isbn: String): Observable<ReviewCountResult> = goodReadsApi.getBookReviewCount(isbn)
}