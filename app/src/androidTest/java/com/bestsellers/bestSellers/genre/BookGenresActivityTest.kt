package com.bestsellers.bestSellers.genre

import android.support.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import android.support.test.rule.ActivityTestRule
import com.bestsellers.bookGenres.BookGenresActivity
import org.junit.Rule
import org.junit.Test


/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */

@RunWith(AndroidJUnit4::class)
class BookGenresActivityTest {

    @get:Rule val activityRule = ActivityTestRule(BookGenresActivity::class.java)
    private val robot: BookGenresActivityRobot = BookGenresActivityRobot();

    @Test
    fun selectedFirstItem_displayBestSellersList() {
        robot.checkFirstItemText("Combined Print & E-Book Fiction").selectListFirstItem().checkDisplayBestSellersList()
    }

    @Test
    fun scrollToBottom_scrollToTop() {
        robot.scrolltoBottom().scrolltoTop()
    }

    @Test
    fun selectLastItem_displayBestSellersList() {
        robot.scrolltoBottom().sleep().checkLastItemText().selectListLastItem().checkDisplayBestSellersList()
    }

    @Test
    fun selectSearchButtonAndMakeSearch_filterList() {
        robot.selectSearchButton().addTextToSearchView("Travel").checkFirstItemText("Travel")
    }

}