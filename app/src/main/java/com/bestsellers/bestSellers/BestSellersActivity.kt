package com.bestsellers.bestSellers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import com.bestsellers.bookDetails.BookDetailsActivity
import com.bestsellers.model.Book
import com.bestsellers.util.launchActivity
import kotlinx.android.synthetic.main.activity_best_sellers.*

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BestSellersActivity : AppCompatActivity(), BestSellersContract.View {

    override lateinit var presenter: BestSellersContract.Presenter
    private var booksList = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_sellers)
        presenter = BestSellersPresenter(this)
        configureRecicleView()
        presenter.requestBestSellers(intent.getStringExtra("genreName"))
    }

    private fun configureRecicleView() {
        bestSellersList.layoutManager = LinearLayoutManager(this)
        bestSellersList.adapter = BestSellersAdapter(booksList) {
            showBookDetails(it)
        }
    }

    private fun showBookDetails(book: Book) {
        launchActivity<BookDetailsActivity> {
            putExtra("book", book)
        }
    }

    override fun showErrorMessage() {
    }

    override fun showLoading() {
        progressBestSellers.visibility = VISIBLE
    }

    override fun hideLoading() {
        progressBestSellers.visibility = GONE
    }

    override fun showBestSellers(bestSeller: List<Book>) {
        booksList.addAll(bestSeller)
        bestSellersList.adapter.notifyDataSetChanged()
    }


}