package com.bestsellers.bestSellers.bestSellers

import com.bestsellers.bestSellers.base.BaseTest
import org.junit.Before
import org.junit.Test

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */

class BestSellersActivityTest : BaseTest() {

    private val robot: BestSellersRobot = BestSellersRobot()

    @Before
    fun init() {
        setup()
        robot.initBestSellersView()
    }

    @Test
    fun testScroll_scrollToTopAndBottom() {
        robot.scrolltoBottom().scrolltoTop()
    }

    @Test
    fun checkAndSelectFirtDisplayedItem_openDetailsView() {
        robot
                .scrolltoTop()
                .checkTittleFromFirstItem()
                .checkDescriptionFromFirstItem()
                .selectFirstItem()
                .checkOpenDetailsView()
    }

    @Test
    fun checkAndSelectLastDisplayedItem_openDetailsView() {
        robot
                .scrolltoBottom()
                .checkTittleFromLastItem()
                .checkDescriptionFromLastItem()
                .selectLastItem()
                .checkOpenDetailsView()
    }

}