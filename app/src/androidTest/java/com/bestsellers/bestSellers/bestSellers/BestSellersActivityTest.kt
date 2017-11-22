package com.bestsellers.bestSellers.bestSellers

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.bestsellers.bestSellers.BestSellersActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */

@RunWith(AndroidJUnit4::class)
class BestSellersActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(BestSellersActivity::class.java)
    private val robot:BestSellersRobot = BestSellersRobot()

    @Test
    fun testScroll(){
        robot.scrolltoBottom().scrolltoTop()
    }

    @Test
    fun selectListItem_openDetailsView(){
        robot.scrolltoTop().selectFirstItem().checkOpenDetailsView()
    }

}