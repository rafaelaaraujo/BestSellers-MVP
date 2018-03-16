package com.bestsellers.bestsellers

import com.bestsellers.R
import com.bestsellers.base.*

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */

class BestSellersRobot : BaseRobot() {

    fun initBestSellersView() {
        clickItemAtPosition(ID_GENRE_LIST, FIRST_ITEM_GENRE)
        sleepTime(1000)
    }

    fun scrolltoLast() {
        scrollListAtPosition(ID_BOOKS_LIST, LAST_BOOK_POSITION)
    }

    fun scrolltoFirst() {
        scrollListAtPosition(ID_BOOKS_LIST, FIRST_BOOK_POSITION)
    }

    fun selectFirstItem() {
        clickItemAtPosition(ID_BOOKS_LIST, FIRST_BOOK_POSITION)
    }

    fun selectLastItem() {
        clickItemAtPosition(ID_BOOKS_LIST, LAST_BOOK_POSITION)
    }

    fun checkTittleFromFirstItem() {
        checkTextFromRecyclerViewItem(ID_BOOKS_LIST, FIRST_BOOK_POSITION, FIRST_BOOK_TITLE)
    }

    fun checkAuthorFromFirstItem() {
        checkTextFromRecyclerViewItem(ID_BOOKS_LIST, FIRST_BOOK_POSITION, FIRST_BOOK_AUTHOR)
    }

    fun checkTittleFromLastItem() {
        checkTextFromRecyclerViewItem(ID_BOOKS_LIST, LAST_BOOK_POSITION, LAST_BOOK_TITLE)
    }

    fun checkAuthorFromLastItem() {
        checkTextFromRecyclerViewItem(ID_BOOKS_LIST, LAST_BOOK_POSITION, LAST_BOOK_DESCRIPTION)
    }

    fun selectDetailsButton(){
        clickItem(R.id.datailsButton)
    }

    private fun checkOpenCorrectBookDetails(bookTitle:String){
        checkItemText(R.id.titleBook, bookTitle)
    }

    fun checkOpenDetailsFirstBook(){
        checkOpenCorrectBookDetails(FIRST_BOOK_TITLE)
    }

    fun checkOpenDetailsLastBook(){
        checkOpenCorrectBookDetails(LAST_BOOK_TITLE)
    }

    fun selectFavoriteButton(){
        sleepTime(2000)
        clickItem(R.id.favoriteButton)
    }

    fun checkFavoriteMessageDisplayed(){
        sleepTime(1000)
        checkSnackBarVisible(FAVORITE_BOOK_MESSAGE)
    }

    fun checkUnfavoriteMessageDisplayed(){
        sleepTime(1000)
        checkSnackBarVisible(UNFAVORITE_BOOK_MESSAGE)
    }

}