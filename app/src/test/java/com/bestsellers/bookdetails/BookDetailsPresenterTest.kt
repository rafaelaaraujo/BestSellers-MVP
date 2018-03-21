package com.bestsellers.bookdetails

import com.bestsellers.BaseTest
import com.bestsellers.bestSellers.BestSellersPresenter
import com.bestsellers.data.model.*
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify

/**
 * Created by Rafaela Araujo
 * on 15/03/2018.
 */
class BookDetailsPresenterTest : BaseTest(){

    @Mock private lateinit var view: BookDetailsContract.View
    private lateinit var presenter: BookDetailsContract.Presenter

    @Before
    fun setup() {
        initMock()
        presenter = BookDetailsPresenter(repository)
        presenter.view = view
    }

    @Test
    fun getBookAverage_updateView() {
        Mockito.`when`(service.getBookAverage("123")).thenReturn(Observable.just(getBookaverage()))

        presenter.apply {
            getBookAverage("123")
        }

        verify(view).loadBookReviewCount(getAverage())
        Mockito.verify(view, Mockito.never()).showErrorMessage()
    }

    @Test
    fun changeBookUnfavoriteState_showFavoriteMessage(){
        presenter.apply {
            changeBookStatus(getEmptyBook(), true)
        }

        verify(view).showFavoriteMessage()
    }

    @Test
    fun changeBookfavoriteState_showUnfavoriteMessage(){
        presenter.apply {
            changeBookStatus(getEmptyBook(), false)
        }
        verify(view).showRemoveFavoriteBookMessage()
    }

    private fun getBookaverage(): BookAverage {
        return BookAverage(listOf(getAverage()))
    }

    private fun getAverage() = Average("10", 5f)

    private fun getEmptyBook() = Book("test", 1, 3, "", "", "", "", "", ArrayList())

}