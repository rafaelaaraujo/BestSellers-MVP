package com.bestsellers.bestSellers.genre

import com.bestsellers.bestSellers.R
import com.bestsellers.bestSellers.base.BaseRobot

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */

class BookGenresActivityRobot : BaseRobot() {


    fun selectListFirstItem(): BookGenresActivityRobot {
        clickItemAtPosition(R.id.genreGrid, 1)
        return this
    }

    fun selectListLastItem(): BookGenresActivityRobot {
        clickItemAtPosition(R.id.genreGrid, 52)
        return this
    }

    fun checkDisplayBestSellersList() {
        checkItemIsVisible(R.id.bestSellersList)
    }

    fun scrolltoBottom(): BookGenresActivityRobot {
        scrollListAtPosition(R.id.genreGrid, 50)
        return this
    }

    fun scrolltoTop() {
        scrollListAtPosition(R.id.genreGrid, 1)
    }

    fun checkFirstItemText(text:String): BookGenresActivityRobot {
        checkTextFromRecicleViewItem(R.id.genreGrid, 0, text)
        return this
    }

    fun checkLastItemText(): BookGenresActivityRobot {
        checkTextFromRecicleViewItem(R.id.genreGrid, 52, "Travel")
        return this
    }

    fun sleep(): BookGenresActivityRobot {
        sleepTime(3000)
        return this
    }

    fun selectSearchButton(): BookGenresActivityRobot {
        clickItem(R.id.search)
        return this
    }

    fun addTextToSearchView(text:String): BookGenresActivityRobot {
        putTextInEditText(text)
        return this
    }

}