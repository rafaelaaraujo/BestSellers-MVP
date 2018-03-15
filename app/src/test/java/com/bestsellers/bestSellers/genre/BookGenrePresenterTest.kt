package com.bestsellers.bestSellers.genre

import com.bestsellers.bookDetails.BookGenresContract
import com.bestsellers.bookGenre.BookGenresPresenter
import com.bestsellers.data.BestSellersRepository
import com.bestsellers.data.model.BookGenres
import com.bestsellers.data.model.Genre
import com.bestsellers.data.remote.BestSellersService
import io.reactivex.Observable.just
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


/**
 * Created by rafaela.araujo on 15/03/18.
 */

class BookGenrePresenterTest {

    private lateinit var repository: BestSellersRepository
    @Mock private lateinit var view: BookGenresContract.View
    @Mock private lateinit var service: BestSellersService
    private lateinit var presenter: BookGenresContract.Presenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repository = BestSellersRepository(service, null, Schedulers.trampoline(),Schedulers.trampoline())
        presenter = BookGenresPresenter(view, repository)
        RxJavaPlugins.reset()
        RxAndroidPlugins.reset()
    }


    @Test
    fun createPresenter_setsThePresenterToView() {
        verify(view).presenter = presenter
    }

    @Test
    fun getBookGenresAndUpdateView() {
        `when`(service.getGenreList()).thenReturn(just(getMockGenreList()))

        presenter.apply {
            requestGenreList()
        }

        verify(view).showLoading()
        verify(view).hideLoading()
        verify(view).showGenreList(getMockGenreList().results)
        verify(view, never()).showErrorMessage()

    }

    private fun getMockGenreList(): BookGenres {
        val list = ArrayList<Genre>()
        list.add(Genre("", "", ""))
        return BookGenres(list)
    }

}