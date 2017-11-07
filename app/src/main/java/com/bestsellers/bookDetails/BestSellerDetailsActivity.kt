package com.bestsellers.bookDetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bestsellers.bestSellers.R
import com.bestsellers.util.showSnackBar
import kotlinx.android.synthetic.main.activity_best_seller_details.*

class BestSellerDetailsActivity : AppCompatActivity(), BestSellerDetailsContract.View {

    override lateinit var presenter: BestSellerDetailsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_seller_details)
        presenter = BestSellerDetailsPresenter(this);
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            showSnackBar(view, "share button clicked")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings ->
                return true
            else -> super.onOptionsItemSelected(item)
        }
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

}
