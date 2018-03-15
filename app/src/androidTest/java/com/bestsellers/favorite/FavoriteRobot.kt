package com.bestsellers.favorite

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.swipeLeft
import android.support.test.espresso.matcher.ViewMatchers.isRoot
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.bestsellers.R
import com.bestsellers.base.*


/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */


class FavoriteRobot : BaseRobot() {

    fun checkListFavoriteBook(){
        pressBack()
        onView(withId(R.id.pager)).perform(swipeLeft())
        checkTextFromRecyclerViewItem(ID_FAVORITE_LIST, FIRST_BOOK_POSITION, FIRST_BOOK_TITLE)
    }

    fun selectBook(){
        clickItemAtPosition(ID_GENRE_LIST, FIRST_ITEM_GENRE)
    }

    private fun pressBack() {
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    fun favoriteBook(){
        clickItem(R.id.favoriteButton)
    }

    fun selectFavoriteBook() {
        selectBook()
        favoriteBook()
        checkListFavoriteBook()
        clickItemAtPosition(ID_FAVORITE_LIST, FIRST_BOOK_POSITION)
    }
}