package com.bestsellers.bestSellers.bestSellers


import com.bestsellers.bestSellers.BestSellersActivity
import com.bestsellers.bestSellers.BestSellersContract
import com.bestsellers.bestSellers.BestSellersPresenter
import com.bestsellers.model.Book
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.Mockito.`when`
import com.squareup.okhttp.mockwebserver.MockWebServer
import org.bouncycastle.crypto.tls.ConnectionEnd.server







/**
 * Created by rafaela.araujo on 08/02/18.
 */

class BestSellersPresenterTest {

    @JvmField @Rule var mockitoRule = MockitoJUnit.rule()
    @Mock private lateinit var mockView: BestSellersContract.View
    private lateinit var presenter: BestSellersPresenter
    private lateinit var server: MockWebServer


    @Before
    fun setup() {
        server = MockWebServer()
        server.start()
        presenter = BestSellersPresenter(mockView)
    }

    @Test
    fun testAttach() {
        assertNotNull(presenter.view)
    }

    @Test
    fun searchBestSellersWithoutGenre() {
        presenter.requestBestSellers("")
        verify(mockView).showErrorMessage()
    }

    @Test
    fun searchBestSellersValidGenre() {
        val bestSellersPresenter = BestSellersPresenter(mock())
        val bestSellersView = mock<BestSellersActivity>()

        bestSellersPresenter.requestBestSellers("combined-print-and-e-book-fiction")
        verify(bestSellersView).showBestSellers(fakeSearchResults)
    }

    private val fakeSearchResults: ArrayList<Book>
        get() {
            val searchResults = Book(
                    1,
                    1,
                    2,
                    "test",
                    "test",
                    10f,
                    "book test",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""
            )
            val list = ArrayList<Book>()
            list.add(searchResults)
            return list
        }
}