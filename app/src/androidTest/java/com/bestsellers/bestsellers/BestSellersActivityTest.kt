package com.bestsellers.bestsellers

import android.support.test.runner.AndroidJUnit4
import com.bestsellers.base.BaseTest
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
    fun checkAndSelectFirstDisplayedItem_openDetailsView() {
        with(robot) {
            scrolltoFirst()
            checkTittleFromFirstItem()
            checkAuthorFromFirstItem()
            selectFirstItem()
            checkOpenDetailsFirstBook()
        }
    }

    @Test
    fun checkAndSelectLastDisplayedItem_openDetailsView() {
        with(robot) {
            scrolltoLast()
            checkTittleFromLastItem()
            checkAuthorFromLastItem()
            selectLastItem()
            checkOpenDetailsLastBook()
        }
    }

    @Test
    fun selectDetailsButton_openDetailsView() {
        with(robot) {
            scrolltoLast()
            checkTittleFromLastItem()
            selectDetailsButton()
            checkOpenDetailsLastBook()
        }
    }

    @Test
    fun selectFavoriteBook_showMessageAndChangeState() {
        with(robot) {
            selectFavoriteButton()

        }
    }

}