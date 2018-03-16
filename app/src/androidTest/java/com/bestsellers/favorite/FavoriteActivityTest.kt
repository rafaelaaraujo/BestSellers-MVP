package com.bestsellers.favorite

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
class FavoriteActivityTest : BaseTest() {

    private val robot: FavoriteRobot = FavoriteRobot()

    @Before
    fun init() {
        setup()
    }

    @Test
    fun addFavorite_showInFavoriteList() {
        with(robot) {
            selectBook()
            favoriteBook()
            checkListFavoriteBook()
        }
    }

    @Test
    fun openFavoriteBook_showBookDetails(){
        with(robot) {
            selectFavoriteBook()
        }
    }

}