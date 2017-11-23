package com.bestsellers.bestSellers.genre

import com.bestsellers.bestSellers.R
import com.bestsellers.bestSellers.base.BaseRobot
import com.squareup.okhttp.mockwebserver.MockWebServer
import android.content.Intent
import com.bestsellers.bestSellers.base.RestServiceTestHelper
import com.bestsellers.util.Constants


/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */

const val LIST_ID = R.id.genreGrid
const val LAST_ITEM = 52
const val FIRST_ITEM = 0

class BookGenresRobot : BaseRobot() {

    private val mockWebServer = MockWebServer()

    init {
        mockWebServer.start()
        Constants.BASE_URL = mockWebServer.getUrl("/").toString()
        mockWebServer.setDispatcher(RestServiceTestHelper.dispatcher)
    }

    fun selectListFirstItem(): BookGenresRobot {
        clickItemAtPosition(LIST_ID, FIRST_ITEM)
        return this
    }

    fun selectListLastItem(): BookGenresRobot {
        clickItemAtPosition(LIST_ID, LAST_ITEM)
        return this
    }

    fun checkDisplayBestSellersList() {
        checkItemIsVisible(R.id.bestSellersList)
    }

    fun scrolltoBottom(): BookGenresRobot {
        scrollListAtPosition(FIRST_ITEM, LAST_ITEM)
        return this
    }

    fun scrolltoTop() {
        scrollListAtPosition(LIST_ID, FIRST_ITEM)
    }

    fun checkFirstItemText(text:String): BookGenresRobot {
        checkTextFromRecicleViewItem(LIST_ID, FIRST_ITEM, text)
        return this
    }

    fun checkLastItemText(): BookGenresRobot {
        checkTextFromRecicleViewItem(LIST_ID, LAST_ITEM, "Travel")
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

    fun addTextToSearchView(text:String): BookGenresRobot {
        putTextInEditText(text)
        return this
    }

}