package com.bestsellers.bestSellers.bookDetails

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.bestsellers.bookDetails.BookDetailsActivity
import org.junit.Rule
import org.junit.runner.RunWith

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */

@RunWith(AndroidJUnit4::class)
class BookDetailsActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(BookDetailsActivity::class.java)


}