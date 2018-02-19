package com.bestsellers.bestSellers.bookDetails

import com.bestsellers.R
import com.bestsellers.bestSellers.base.*

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */


class BookDetailsRobot : BaseRobot() {

    fun selectGenreItem(){
        sleepTime(2000);
        clickItemAtPosition(ID_GENRE_LIST, FIRST_ITEM_GENRE)
    }

    fun selectNoReviewBook(){
        clickItemAtPosition(ID_BOOKS_LIST, FIRST_BOOK_POSITION)
    }

    fun selectReviewBook(){
        clickItemAtPosition(ID_BOOKS_LIST, ITEM_REVIEW_BOOK_POSITION)
    }

    fun clickTobuyNoReviewBook(){
        checkItemIsVisible(R.id.buyButton)
        clickItem(R.id.buyButton)
    }

    fun clickTobuyReviewBook(){
        checkItemIsVisible(R.id.btnBuyBook)
        clickItem(R.id.btnBuyBook)
    }

    fun checkReviewIsVisible(){
        checkItemIsVisible(R.id.reviewWebView)
    }

    fun checkDataBookIsVisible(){
        checkItemIsVisible(R.id.llBookData)
    }

    fun scrolltoBottom() {
        scrollListAtPosition(ID_BOOKS_LIST, LAST_ITEM_GENRE)
    }

    fun waitTime(time: Long){
        sleepTime(time)
    }
}