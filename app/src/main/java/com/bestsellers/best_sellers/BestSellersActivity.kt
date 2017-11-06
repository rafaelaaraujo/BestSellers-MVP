package com.bestsellers.best_sellers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bestsellers.model.BestSeller

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BestSellersActivity : AppCompatActivity(), BestSellersContract.View {

    override lateinit var presenter: BestSellersContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_sellers)
        presenter = BestSellersPresenter(this)
    }
    override fun showErrorMessage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showBestSellers(bestSeller:List<BestSeller>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}