package com.bestsellers.bestSellers.bestSellers

import android.support.test.runner.AndroidJUnit4
import com.bestsellers.bestSellers.base.BaseTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */

@RunWith(AndroidJUnit4::class)
class BestSellersActivityTest : BaseTest() {

    private val robot: BestSellersRobot = BestSellersRobot()

    @Before
    fun init() {
        setup()
        robot.initBestSellersView()
    }

    @Test
    fun testScroll_scrollToTopAndBottom() {
        with(robot){
            scrolltoBottom()
            scrolltoTop()
        }
    }

    @Test
    fun checkAndSelectFirstDisplayedItem_openDetailsView() {
        with(robot) {
            scrolltoTop()
            checkTittleFromFirstItem()
            checkDescriptionFromFirstItem()
            selectFirstItem()
            checkOpenDetailsView()
        }
    }

    @Test
    fun checkAndSelectLastDisplayedItem_openDetailsView() {
        with(robot) {
            scrolltoBottom()
            checkTittleFromLastItem()
            checkDescriptionFromLastItem()
            selectLastItem()
            checkOpenDetailsView()
        }
    }

}