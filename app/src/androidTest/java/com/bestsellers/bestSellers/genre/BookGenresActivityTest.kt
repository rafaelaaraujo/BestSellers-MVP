package com.bestsellers.bestSellers.genre

import com.bestsellers.bestSellers.base.BaseTest
import org.junit.Test


/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */

class BookGenresActivityTest : BaseTest(){

    private val robot: BookGenresRobot = BookGenresRobot()

    @Test
    fun selectedFirstItem_displayBestSellersList() {
        robot
                .checkFirstItemText()
                .selectListFirstItem()
                .checkDisplayBestSellersList()
    }

    @Test
    fun scrollToBottom_scrollToTop() {
        robot
                .scrolltoBottom()
                .scrolltoTop()
    }

    @Test
    fun selectLastItem_displayBestSellersList() {
        robot
                .scrolltoBottom()
                .waitTime()
                .checkLastItemText()
                .selectListLastItem()
                .checkDisplayBestSellersList()
    }

    @Test
    fun selectSearchButtonAndMakeSearch_filterList() {
        robot
                .selectSearchButton()
                .addTextToSearchView()
                .checkFirstItemSearchText()
    }

}