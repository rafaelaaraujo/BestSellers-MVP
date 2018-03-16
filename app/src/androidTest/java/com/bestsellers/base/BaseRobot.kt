package com.bestsellers.base

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.v7.widget.RecyclerView
import android.widget.EditText
import org.hamcrest.Matchers.allOf


/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */
abstract class BaseRobot {

    protected fun clickItem(itemId: Int) {
        onView(withId(itemId)).perform(click())
    }

    protected fun checkItemIsVisible(itemId: Int) {
        onView(withId(itemId)).check(matches(isDisplayed()))
    }

    protected fun clickItemAtPosition(itemId: Int, position: Int) {
        onView(withId(itemId)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(position, click()))
    }

    protected fun scrollListAtPosition(itemId: Int, position: Int) {
        onView(withId(itemId)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(position))
    }

    protected fun checkTextFromRecyclerViewItem(listId: Int, itemPosition: Int, text: String) {
        onView(withRecyclerView(listId).atPosition(itemPosition))
                .check(matches(hasDescendant(withText(text))))
    }

    private fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }

    fun sleepTime(time: Long) {
        Thread.sleep(time)
    }

    protected fun putTextInEditText(text: String) {
        onView(isAssignableFrom(EditText::class.java)).perform(typeText(text), pressImeActionButton())
    }

    protected fun checkItemText(itemId: Int, text: String){
        onView(withId(itemId)).check(matches(withText(text)))
    }

    protected fun checkSnackBarVisible(text: String){
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(text))).check(matches(isDisplayed()))
    }

}