//package com.bestsellers.bestSellers.bestSellers
//
//
//import com.bestsellers.bestSellers.BestSellersContract
//import com.bestsellers.bestSellers.BestSellersPresenter
//import com.bestsellers.connection.BestSellersService
//import com.bestsellers.model.BestSellersResult
//import com.bestsellers.model.Book
//import com.bestsellers.model.Results
//import com.nhaarman.mockito_kotlin.verify
//import io.reactivex.Observable
//import junit.framework.Assert.assertNotNull
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.ArgumentMatchers.anyString
//import org.mockito.Mock
//import org.mockito.Mockito.`when`
//import org.mockito.MockitoAnnotations
//import org.mockito.junit.MockitoJUnit
//
//
///**
// * Created by rafaela.araujo on 08/02/18.
// */
//class BestSellersPresenterTest {
//
//    @JvmField
//    @Rule
//    var mockitoRule = MockitoJUnit.rule()
//    @Mock private lateinit var mockView: BestSellersContract.View
//    private lateinit var presenter: BestSellersPresenter
//    @Mock lateinit var service: BestSellersService
//
//    @Before
//    fun setup() {
//        MockitoAnnotations.initMocks(this)
//        presenter = BestSellersPresenter(mockView, service)
//        `when`(service.getBestSeller(anyString())).thenReturn(Observable.just(fakeSearchResults))
//
//    }
//
//    @Test
//    fun testAttach() {
//        assertNotNull(presenter.view)
//    }
//
//    @Test
//    fun searchBestSellersWithoutGenre() {
//        presenter.requestBestSellers("")
//        verify(mockView).showErrorMessage()
//    }
//
//    private val fakeSearchResults: BestSellersResult
//        get() {
//            val result = BestSellersResult(
//                    "",
//                    0,
//                    results = Results(
//                            "teste",
//                            "",
//                            "",
//                            "",
//                            "",
//                            "",
//                            getBooks()
//                    )
//
//            )
//
//            return result
//
//        }
//
//    fun getBooks(): ArrayList<Book> {
//        val searchResults = Book(
//                1,
//                1,
//                2,
//                "test",
//                "test",
//                10f,
//                "book test",
//                "",
//                "",
//                "",
//                "",
//                "",
//                "",
//                ""
//        )
//        val list = ArrayList<Book>()
//        list.add(searchResults)
//        return list
//    }
//}