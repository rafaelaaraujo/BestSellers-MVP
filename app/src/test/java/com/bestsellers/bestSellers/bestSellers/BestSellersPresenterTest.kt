//package com.bestsellers.bestSellers.bestSellers
//
//
//import android.support.test.runner.AndroidJUnit4
//import com.bestsellers.bestSellers.BestSellersActivity
//import com.bestsellers.bestSellers.BestSellersContract
//import com.bestsellers.bestSellers.BestSellersPresenter
//import com.bestsellers.bestSellers.base.BaseTest
//import com.bestsellers.model.Book
//import com.nhaarman.mockito_kotlin.mock
//import com.nhaarman.mockito_kotlin.verify
//import junit.framework.Assert.assertNotNull
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.junit.MockitoJUnitRunner
//
///**
// * Created by rafaela.araujo on 08/02/18.
// */
//
//@RunWith(MockitoJUnitRunner::class)
//class BestSellersPresenterTest {
//
//    @Test
//    fun testAttach() {
//        val bestSellersPresenter = BestSellersPresenter(mock())
//        assertNotNull(bestSellersPresenter.view)
//    }
//
//    @Test
//    fun searchBestSellersWithoutGenre() {
//        val bestSellersPresenter = BestSellersPresenter(mock())
//        val bestSellersView = mock<BestSellersContract.View>()
//
//        bestSellersPresenter.requestBestSellers("")
//        verify(bestSellersView).showErrorMessage()
//    }
//
//    @Test
//    fun searchBestSellersValidGenre() {
//        val bestSellersPresenter = BestSellersPresenter(mock())
//        val bestSellersView = mock<BestSellersActivity>()
//
//        bestSellersPresenter.requestBestSellers("combined-print-and-e-book-fiction")
//        verify(bestSellersView).showBestSellers(fakeSearchResults)
//    }
//
//    private val fakeSearchResults: ArrayList<Book>
//        get() {
//            val searchResults = Book(
//                    1,
//                    1,
//                    2,
//                    "test",
//                    "test",
//                    10f,
//                    "book test",
//                    "",
//                    "",
//                    "",
//                    "",
//                    "",
//                    "",
//                    ""
//            )
//            val list = ArrayList<Book>()
//            list.add(searchResults)
//            return list
//        }
//}