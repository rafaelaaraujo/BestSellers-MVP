package com.bestsellers.favorite

import com.bestsellers.BaseTest
import com.bestsellers.data.model.Book
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify

/**
 * Created by rafaela.araujo on 22/03/18.
 */
class FavoritePresenterTest : BaseTest() {

    @Mock private lateinit var view: FavoriteContract.View
    private lateinit var presenter: FavoriteContract.Presenter

    @Before
    fun setup() {
        initMock()
        presenter = FavoritePresenter(repository)
        presenter.view = view
    }

    @Test
    fun getFavoritesBook_showErrorMessage(){

        Mockito.`when`(favoriteDao.loadAllFavoriteBooks()).thenReturn(ArrayList())

        presenter.apply {
            getFavoriteBooks()
        }

        verify(view).showLoading()
        verify(view).hideLoading()
        verify(view).showErrorMessage()
    }

    @Test
    fun getFavoritesBook_updateBooksList(){

        Mockito.`when`(favoriteDao.loadAllFavoriteBooks()).thenReturn(listOf(getEmptyBook()))

        presenter.apply {
            getFavoriteBooks()
        }

        verify(view).showLoading()
        verify(view).hideLoading()
        verify(view).showFavoriteBooks(listOf(getEmptyBook()))
    }

    private fun getEmptyBook() = Book("test", 1, 3, "", "", "", "", "", ArrayList())

}