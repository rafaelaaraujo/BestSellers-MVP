package com.bestsellers.bestSellers.bestSellers

import com.bestsellers.bestSellers.BaseTest
import com.bestsellers.bestSellers.BestSellersContract
import com.bestsellers.bestSellers.BestSellersPresenter
import com.bestsellers.data.model.BestSellers
import com.bestsellers.data.model.Book
import com.bestsellers.data.model.Results
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*

/**
 * Created by Rafaela Araujo
 * on 15/03/2018.
 */
class BestSellersPresenterTest : BaseTest(){

    @Mock private lateinit var view: BestSellersContract.View
    private lateinit var presenter: BestSellersContract.Presenter

    @Before
    fun setup() {
        initMock()
        presenter = BestSellersPresenter(view, repository)
    }

    @Test
    fun getBestSellersList_UpdateView(){
        `when`(service.getBestSeller(anyString())).thenReturn(Observable.just(getBestSellersMock()))

        presenter.apply {
            requestBestSellers("")
        }

        verify(view).showLoading()
        verify(view).hideLoading()
        verify(view).showBestSellers(getBestSellersMock().results.books)
        verify(view, Mockito.never()).showErrorMessage()
    }

    @Test
    fun getEmptyBestSellersList_UpdateView(){
        `when`(service.getBestSeller(anyString())).thenReturn(Observable.just(BestSellers(Results(ArrayList()))))

        presenter.apply {
            requestBestSellers("")
        }

        verify(view).showLoading()
        verify(view).hideLoading()
        verify(view).showErrorMessage()
        verify(view, never()).showBestSellers(ArrayList())
    }

    @Test
    fun changeBookUnfavoriteState_showFavoriteMessage(){
        presenter.apply {
            changeBookStatus(getEmptyBook(), true)
        }

        verify(view).showFavoriteBookMessage()
    }

    @Test
    fun changeBookfavoriteState_showUnfavoriteMessage(){
        presenter.changeBookStatus(getEmptyBook(), false)
        verify(view).showRemoveFavoriteBookMessage()
    }

    private fun getBestSellersMock(): BestSellers {
        return BestSellers(Results(listOf(getEmptyBook())))
    }

    private fun getEmptyBook() = Book("test", 1, 3, "", "", "", "", "", ArrayList())
}