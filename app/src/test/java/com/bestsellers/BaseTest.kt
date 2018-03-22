package com.bestsellers

import com.bestsellers.data.BestSellersRepository
import com.bestsellers.data.local.FavoriteBookDao
import com.bestsellers.data.remote.BestSellersService
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.koin.test.KoinTest
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

open class BaseTest : KoinTest {

    lateinit var repository: BestSellersRepository
    @Mock lateinit var service: BestSellersService
    @Mock lateinit var favoriteDao: FavoriteBookDao

    fun initMock() {
        MockitoAnnotations.initMocks(this)
        repository = BestSellersRepository(service, favoriteDao, Schedulers.trampoline(), Schedulers.trampoline())
    }
}