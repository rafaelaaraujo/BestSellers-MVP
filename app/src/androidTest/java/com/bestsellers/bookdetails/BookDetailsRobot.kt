package com.bestsellers.bookdetails

import com.bestsellers.R
import com.bestsellers.base.*

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */


class BookDetailsRobot : BaseRobot() {
    
    fun initDetailsView(){
        sleepTime(2000)
        clickItemAtPosition(ID_GENRE_LIST, FIRST_ITEM_GENRE)
        selectBook()
    }

    private fun selectBook(){
        clickItemAtPosition(ID_BOOKS_LIST, ITEM_BOOK_POSITION)
    }

    fun checkBookTitle(){
        checkItemText(R.id.titleBook, FIRST_BOOK_TITLE)
    }

    fun checkBookDescription(){
        checkItemText(R.id.desc, FIRST_BOOK_DESCRIPTION)
    }

    fun checkBookWriter(){
        checkItemText(R.id.writer, FIRST_BOOK_AUTHOR)
    }

    fun checkBookPosition(){
        checkItemText(R.id.rankPosition, "1")
    }

    fun selectFavoriteButton(){
        clickItem(R.id.favorite)
    }

    fun checkFavoriteMessageDisplayed(){
        sleepTime(1000)
        checkSnackBarVisible(FAVORITE_BOOK_MESSAGE)
    }

    fun checkUnfavoriteMessageDisplayed(){
        sleepTime(1000)
        checkSnackBarVisible(UNFAVORITE_BOOK_MESSAGE)
    }

    fun selectBuyButton(){
        clickItem(R.id.shopButton)
    }
}