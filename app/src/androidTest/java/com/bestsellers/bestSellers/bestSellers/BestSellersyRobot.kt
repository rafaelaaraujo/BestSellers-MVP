package com.bestsellers.bestSellers.bestSellers

import com.bestsellers.bestSellers.R
import com.bestsellers.bestSellers.base.BaseRobot

/**
 * Created by Rafaela Araujo
 * on 15/11/2017.
 */
const val LIST_ID = R.id.bestSellersList

class BestSellersRobot : BaseRobot() {

    fun scrolltoBottom(): BestSellersRobot {
        scrollListAtPosition(LIST_ID, 10)
        return this
    }

    fun scrolltoTop() : BestSellersRobot{
        scrollListAtPosition(LIST_ID, 1)
        return this
    }

    fun selectFirstItem():BestSellersRobot{
        clickItemAtPosition(LIST_ID,1)
        return this
    }

    fun checkOpenDetailsView(){
        checkItemIsVisible(R.id.detailsView)
    }

}