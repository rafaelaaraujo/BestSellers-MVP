package com.bestsellers.bestSellers.genre

import com.bestsellers.bestSellers.R
import com.bestsellers.bestSellers.base.*

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */


class BookGenresRobot : BaseRobot() {

    fun selectListFirstItem(): BookGenresRobot {
        clickItemAtPosition(LIST_ID_GENRE, FIRST_ITEM_GENRE)
        return this
    }

    fun selectListLastItem(): BookGenresRobot {
        clickItemAtPosition(LIST_ID_GENRE, LAST_ITEM_GENRE)
        return this
    }

    fun checkDisplayBestSellersList() {
        checkItemIsVisible(R.id.bestSellersList)
    }

    fun scrolltoBottom(): BookGenresRobot {
        scrollListAtPosition(FIRST_ITEM_GENRE, LAST_ITEM_GENRE)
        return this
    }

    fun scrolltoTop() {
        scrollListAtPosition(LIST_ID_GENRE, FIRST_ITEM_GENRE)
    }

    fun checkFirstItemText(): BookGenresRobot {
        checkTextFromRecicleViewItem(LIST_ID_GENRE, FIRST_ITEM_GENRE, FIRST_ITEM_TEXT_GENRE)
        return this
    }

    fun checkLastItemText(): BookGenresRobot {
        checkTextFromRecicleViewItem(LIST_ID_GENRE, LAST_ITEM_GENRE, LAST_ITEM_TEXT_GENRE)
        return this
    }

    fun waitTime(): BookGenresRobot {
        sleepTime(3000)
        return this
    }

    fun selectSearchButton(): BookGenresRobot {
        clickItem(R.id.search)
        return this
    }

    fun addTextToSearchView(): BookGenresRobot {
        putTextInEditText(SEARCH_TEXT_GENRE)
        return this
    }

    fun checkFirstItemSearchText() {
        checkTextFromRecicleViewItem(LIST_ID_GENRE, FIRST_ITEM_GENRE,  SEARCH_TEXT_GENRE)
    }

}