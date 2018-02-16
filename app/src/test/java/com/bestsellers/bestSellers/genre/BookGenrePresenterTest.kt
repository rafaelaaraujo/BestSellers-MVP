//package com.bestsellers.bestSellers.genre
//
//import com.bestsellers.bookDetails.BookGenresContract
//import com.bestsellers.bookGenres.BookGenresPresenter
//import com.bestsellers.connection.BestSellersApi
//import com.bestsellers.connection.BestSellersService
//import com.bestsellers.model.BookGenresResult
//import org.mockito.Mock
//import org.mockito.MockitoAnnotations
//import org.junit.Before
//import io.reactivex.Flowable
//import io.reactivex.Observable
//import org.junit.Test
//import org.mockito.Mockito.*
//import org.mockito.Mockito.`when`
//
//
//
//
///**
// * Created by Rafaela Araujo
// * on 14/02/2018.
// */
//class BookGenrePresenterTest {
//
//    @Mock
//    lateinit var view: BookGenresContract.View
//    @Mock
//    lateinit var model: BookGenresResult
//
//    @Mock
//    lateinit var service: BestSellersService
//
//    private lateinit var presenter:BookGenresContract.Presenter
//
//
//    @Before
//    fun setUp() {
//        MockitoAnnotations.initMocks(this)
//        presenter = BookGenresPresenter(view)
//    }
//
//    @Test
//    fun loadItems_WhenDataIsAvailable_ShouldUpdateViews() {
//        doReturn(Observable.just(model)).`when`(service).getGenreList()
//        presenter.requestGenreList()
//        verify(view).showGenreList(model.results)
//    }
//
//}
//
//
//
