package com.bestsellers.base

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import com.bestsellers.data.local.AppDatabase
import com.bestsellers.main.MainActivity
import com.bestsellers.util.GOODREADS_BASE_URL
import com.bestsellers.util.NY_BASE_URL
import com.squareup.okhttp.mockwebserver.MockWebServer
import org.junit.Rule


/**
 * Created by Rafaela Araujo
 * on 04/12/2017.
 */

open class BaseTest {

    private val mockWebServer = MockWebServer()

    @get:Rule
    private val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    fun setup(){
        mockWebServer.start()
        NY_BASE_URL = mockWebServer.getUrl("/").toString()
        GOODREADS_BASE_URL = mockWebServer.getUrl("/").toString()
        mockWebServer.setDispatcher(RestMockServer.dispatcher)

        val grouchyIntent = Intent()
        activityRule.launchActivity(grouchyIntent)
        AppDatabase.getInstance(activityRule.activity)?.getFavoriteBookDao()?.removeAll()
    }
}