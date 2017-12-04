package com.bestsellers.bestSellers.bestSellers

import com.bestsellers.bestSellers.R
import com.bestsellers.bestSellers.base.*

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */

class BestSellersRobot : BaseRobot() {

    fun initBestSellersView(){
        clickItemAtPosition(LIST_ID_GENRE,FIRST_ITEM_GENRE)
    }

    fun scrolltoBottom(): BestSellersRobot {
        scrollListAtPosition(LIST_ID_BEST_SELLERS, LAST_ITEM_POSITION_BEST_SELLERS)
        return this
    }

    fun scrolltoTop(): BestSellersRobot {
        scrollListAtPosition(LIST_ID_BEST_SELLERS, FIRST_ITEM_POSITION_BEST_SELLERS)
        return this
    }

    fun selectFirstItem(): BestSellersRobot {
        clickItemAtPosition(LIST_ID_BEST_SELLERS, FIRST_ITEM_POSITION_BEST_SELLERS)
        return this
    }

    fun selectLastItem(): BestSellersRobot {
        clickItemAtPosition(LIST_ID_BEST_SELLERS, LAST_ITEM_POSITION_BEST_SELLERS)
        return this
    }

    fun checkOpenDetailsView() {
        checkItemIsVisible(R.id.detailsView)
    }

    fun checkTittleFromFirstItem(): BestSellersRobot {
        checkTextFromRecicleViewItem(LIST_ID_BEST_SELLERS, FIRST_ITEM_POSITION_BEST_SELLERS, FIRST_ITEM_TITLE_BEST_SELLERS)
        return this
    }

    fun checkDescriptionFromFirstItem(): BestSellersRobot {
        checkTextFromRecicleViewItem(LIST_ID_BEST_SELLERS, FIRST_ITEM_POSITION_BEST_SELLERS, FIRST_ITEM_DESCRIPTION_BEST_SELLERS)
        return this
    }


    fun checkTittleFromLastItem(): BestSellersRobot {
        checkTextFromRecicleViewItem(LIST_ID_BEST_SELLERS, LAST_ITEM_POSITION_BEST_SELLERS, LAST_ITEM_TITLE_BEST_SELLERS)
        return this
    }

    fun checkDescriptionFromLastItem(): BestSellersRobot {
        checkTextFromRecicleViewItem(LIST_ID_BEST_SELLERS, LAST_ITEM_POSITION_BEST_SELLERS, LAST_ITEM_DESCRIPTION_BEST_SELLERS)
        return this
    }

}