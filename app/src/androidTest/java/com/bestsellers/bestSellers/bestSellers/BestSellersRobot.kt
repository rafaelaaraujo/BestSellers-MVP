package com.bestsellers.bestSellers.bestSellers

import com.bestsellers.bestSellers.R
import com.bestsellers.bestSellers.base.*

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */

class BestSellersRobot : BaseRobot() {

    fun initBestSellersView() {
        clickItemAtPosition(ID_GENRE_LIST, FIRST_ITEM_GENRE)
    }

    fun scrolltoBottom(): BestSellersRobot {
        scrollListAtPosition(ID_BOOKS_LIST, LAST_BOOK_POSITION)
        return this
    }

    fun scrolltoTop(): BestSellersRobot {
        scrollListAtPosition(ID_BOOKS_LIST, FIRST_BOOK_POSITION)
        return this
    }

    fun selectFirstItem(): BestSellersRobot {
        clickItemAtPosition(ID_BOOKS_LIST, FIRST_BOOK_POSITION)
        return this
    }

    fun selectLastItem(): BestSellersRobot {
        clickItemAtPosition(ID_BOOKS_LIST, LAST_BOOK_POSITION)
        return this
    }

    fun checkOpenDetailsView() {
        checkItemIsVisible(R.id.detailsView)
    }

    fun checkTittleFromFirstItem(): BestSellersRobot {
        checkTextFromRecicleViewItem(ID_BOOKS_LIST, FIRST_BOOK_POSITION, FIRST_BOOK_TITLE)
        return this
    }

    fun checkDescriptionFromFirstItem(): BestSellersRobot {
        checkTextFromRecicleViewItem(ID_BOOKS_LIST, FIRST_BOOK_POSITION, FIRST_BOOK_DESCRIPTION)
        return this
    }


    fun checkTittleFromLastItem(): BestSellersRobot {
        checkTextFromRecicleViewItem(ID_BOOKS_LIST, LAST_BOOK_POSITION, LAST_BOOK_TITLE)
        return this
    }

    fun checkDescriptionFromLastItem(): BestSellersRobot {
        checkTextFromRecicleViewItem(ID_BOOKS_LIST, LAST_BOOK_POSITION, LAST_BOOK_DESCRIPTION)
        return this
    }

}