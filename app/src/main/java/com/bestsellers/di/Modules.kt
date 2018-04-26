package com.bestsellers.di

import com.bestsellers.bestsellers.BestSellersActivity
import com.bestsellers.bestsellers.BestSellersContract
import com.bestsellers.bestsellers.BestSellersPresenter
import com.bestsellers.bookgenre.BookGenresFragment
import com.bestsellers.bookgenre.BookGenresPresenter
import com.bestsellers.bookdetails.BookDetailsActivity
import com.bestsellers.bookdetails.BookDetailsContract
import com.bestsellers.bookdetails.BookDetailsPresenter
import com.bestsellers.bookdetails.BookGenresContract
import com.bestsellers.data.BestSellersRepository
import com.bestsellers.favorite.FavoriteContract
import com.bestsellers.favorite.FavoriteFragment
import com.bestsellers.favorite.FavoritePresenter
import org.koin.dsl.module.applicationContext

/**
 * Koin main module
 */
val module = applicationContext {

    factory { BookGenresPresenter(get()) as BookGenresContract.Presenter }
    factory { FavoritePresenter(get()) as FavoriteContract.Presenter }
    factory { param -> BestSellersPresenter(param["booksGenre"], get()) as BestSellersContract.Presenter }
    factory { BookDetailsPresenter(get()) as BookDetailsContract.Presenter }

    bean { BestSellersRepository() }
}

/**
 * module list
 */
val appModules = listOf(module)
