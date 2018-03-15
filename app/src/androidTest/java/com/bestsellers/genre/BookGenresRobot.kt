package com.bestsellers.genre

import com.bestsellers.R
import com.bestsellers.base.*

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
        checkItemIsVisible(R.id.bestsellersView)
    }

    fun scrolltoBottom() {
        scrollListAtPosition(ID_GENRE_LIST, LAST_ITEM_GENRE)
    }

    fun scrolltoTop() {
        scrollListAtPosition(ID_GENRE_LIST, FIRST_ITEM_GENRE)
    }

    fun checkFirstItemText() {
        checkTextFromRecyclerViewItem(ID_GENRE_LIST, FIRST_ITEM_GENRE, FIRST_ITEM_TEXT_GENRE)
    }

    fun checkLastItemText() {
        checkTextFromRecyclerViewItem(ID_GENRE_LIST, LAST_ITEM_GENRE, LAST_ITEM_TEXT_GENRE)
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
        checkTextFromRecyclerViewItem(ID_GENRE_LIST, FIRST_ITEM_GENRE,  SEARCH_TEXT_GENRE)
    }

}