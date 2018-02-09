package com.bestsellers.bestSellers.base

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.bestsellers.bookGenres.BookGenresActivity
import com.bestsellers.util.BASE_URL
import com.squareup.okhttp.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith


/**
 * Created by Rafaela Araujo
 * on 04/12/2017.
 */

open class BaseTest {

    private val mockWebServer = MockWebServer()

    @get:Rule
    private val activityRule = ActivityTestRule(BookGenresActivity::class.java, true, false)

    /**
     * configures the mock server to return the expected values
     * ​​and starts default activity
     *
     */
    fun setup(){
        mockWebServer.start()
        BASE_URL = mockWebServer.getUrl("/").toString()
        mockWebServer.setDispatcher(RestMockServer.dispatcher)

        val grouchyIntent = Intent()
        activityRule.launchActivity(grouchyIntent)
    }


}