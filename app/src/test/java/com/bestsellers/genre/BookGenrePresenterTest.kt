package com.bestsellers.genre

import com.bestsellers.BaseTest
import com.bestsellers.bookdetails.BookGenresContract
import com.bestsellers.bookGenre.BookGenresPresenter
import com.bestsellers.bookdetails.BookDetailsPresenter
import com.bestsellers.data.model.BookGenres
import com.bestsellers.data.model.Genre
import io.reactivex.Observable.just
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*


/**
 * Created by rafaela.araujo on 15/03/18.
 */

class BookGenrePresenterTest: BaseTest() {

    @Mock private lateinit var view: BookGenresContract.View
    private lateinit var presenter: BookGenresContract.Presenter

    @Before
    fun setup() {
        initMock()
        presenter = BookGenresPresenter(repository)
        presenter.view = view
    }

    @Test
    fun getGenreList_AndUpdateView() {
        `when`(service.getGenreList()).thenReturn(just(getMockGenreList()))

       presenter.apply {
            requestGenreList()
        }

        verify(view).showLoading()
        verify(view).hideLoading()
        verify(view).showGenreList(getMockGenreList().results)
        verify(view, never()).showErrorMessage()
    }


    @Test
    fun getEmptyGenreList_ShowMessageError() {
        `when`(service.getGenreList()).thenReturn(just(BookGenres(ArrayList())))

       presenter.apply {
            requestGenreList()
        }

        verify(view).showLoading()
        verify(view).hideLoading()
        verify(view).showErrorMessage()
        verify(view, never()).showGenreList(ArrayList())
    }

    private fun getMockGenreList(): BookGenres {
        return BookGenres(listOf(Genre("", "", "")))
    }

}