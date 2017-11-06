package com.bestsellers.best_sellers

import com.bestsellers.common.BasePresenter
import com.bestsellers.common.BaseView
import com.bestsellers.model.BestSeller

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BestSellersContract {

    interface View : BaseView<Presenter> {

        fun showBestSellers(bestSeller: List<BestSeller>)

    }

    interface Presenter : BasePresenter {


    }
}