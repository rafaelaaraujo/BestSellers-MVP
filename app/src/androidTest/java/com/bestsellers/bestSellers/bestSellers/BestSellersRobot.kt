package com.bestsellers.bestSellers.bestSellers

import com.bestsellers.R
import com.bestsellers.bestSellers.base.*

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */

class BestSellersRobot : BaseRobot() {

    fun initBestSellersView() {
        clickItemAtPosition(ID_GENRE_LIST, FIRST_ITEM_GENRE)
        sleepTime(2000);
    }

    fun scrolltoBottom() {
        scrollListAtPosition(ID_BOOKS_LIST, LAST_BOOK_POSITION)
    }

    fun scrolltoTop() {
        scrollListAtPosition(ID_BOOKS_LIST, FIRST_BOOK_POSITION)
    }

    fun selectFirstItem() {
        clickItemAtPosition(ID_BOOKS_LIST, FIRST_BOOK_POSITION)
    }

    fun selectLastItem() {
        clickItemAtPosition(ID_BOOKS_LIST, LAST_BOOK_POSITION)
    }

    fun checkOpenDetailsView() {
        checkItemIsVisible(R.id.detailsView)
    }

    fun checkTittleFromFirstItem() {
        checkTextFromRecicleViewItem(ID_BOOKS_LIST, FIRST_BOOK_POSITION, FIRST_BOOK_TITLE)
    }

    fun checkDescriptionFromFirstItem() {
        checkTextFromRecicleViewItem(ID_BOOKS_LIST, FIRST_BOOK_POSITION, FIRST_BOOK_DESCRIPTION)
    }


    fun checkTittleFromLastItem() {
        checkTextFromRecicleViewItem(ID_BOOKS_LIST, LAST_BOOK_POSITION, LAST_BOOK_TITLE)
    }

    fun checkDescriptionFromLastItem() {
        checkTextFromRecicleViewItem(ID_BOOKS_LIST, LAST_BOOK_POSITION, LAST_BOOK_DESCRIPTION)
    }

}