package com.bestsellers.bestSellers.genre

import com.bestsellers.bestSellers.R
import com.bestsellers.bestSellers.base.*

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */


class BookGenresRobot : BaseRobot() {

    fun selectListFirstItem() {
        clickItemAtPosition(ID_GENRE_LIST, FIRST_ITEM_GENRE)
    }

    fun selectLastItem() {
        clickItemAtPosition(ID_GENRE_LIST, LAST_ITEM_GENRE)
    }

    fun checkDisplayBestSellersList() {
        checkItemIsVisible(R.id.bestSellersList)
    }

    fun scrolltoBottom() {
        scrollListAtPosition(ID_GENRE_LIST, LAST_ITEM_GENRE)
    }

    fun scrolltoTop() {
        scrollListAtPosition(ID_GENRE_LIST, FIRST_ITEM_GENRE)
    }

    fun checkFirstItemText() {
        checkTextFromRecicleViewItem(ID_GENRE_LIST, FIRST_ITEM_GENRE, FIRST_ITEM_TEXT_GENRE)
    }

    fun checkLastItemText() {
        checkTextFromRecicleViewItem(ID_GENRE_LIST, LAST_ITEM_GENRE, LAST_ITEM_TEXT_GENRE)
    }

    fun waitTime() {
        sleepTime(2000)
    }

    fun selectSearchButton() {
        clickItem(R.id.search)
    }

    fun addTextToSearchView() {
        putTextInEditText(SEARCH_TEXT_GENRE)
    }

    fun checkItemSearchDisplayed() {
        checkTextFromRecicleViewItem(ID_GENRE_LIST, FIRST_ITEM_GENRE,  SEARCH_TEXT_GENRE)
    }

}