package com.bestsellers.bookDetails

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.webkit.WebView
import android.webkit.WebViewClient
import com.bestsellers.R
import com.bestsellers.common.BaseActivity
import com.bestsellers.model.Book
import com.bestsellers.util.BOOK
import com.bestsellers.util.loadUrl
import com.bestsellers.util.openUrlInBrowser
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*

class BookDetailsActivity : BaseActivity(), BookDetailsContract.View {

    override lateinit var presenter: BookDetailsContract.Presenter
    private var book: Book? = null
    private lateinit var menuFavorite: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        hideStatusBar()
        presenter = BookDetailsPresenter(this)
        book = intent.extras.getSerializable(BOOK) as? Book
        setBookInformations()
    }

    private fun setBookInformations() {
        book?.apply {
            configureActionBar(title, toolbar)
            expandedImage.loadUrl(book_image)
            weeksOnList.text = getWeeksOnTheList(weeks_on_list)
            writer.text = contributor
            desc.text = description
            txtIsbn13.text = getString(R.string.isbn13, isbns[0].isbn13)
            txtIsbn10.text = getString(R.string.isbn10, isbns[0].isbn10)
            txtPublisher.text = getString(R.string.publisher, publisher)
            txtPublished.text = getString(R.string.published, published_date)
        }

        fabShopBook.setOnClickListener { openUrlInBrowser(book?.amazon_product_url) }
    }

    private fun getWeeksOnTheList(weeks_on_list: Int): String {
        return if (weeks_on_list <= 1) {
            getString(R.string.new_this_week)
        } else {
            getString(R.string.weeks_on_list, weeks_on_list)
        }
    }

    override fun loadBookReview(reviewUrl: String) {
        llBookData.visibility = GONE
        btnBuyBook.visibility = VISIBLE

        reviewWebView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                hideLoading()
            }
        }
        reviewWebView.loadUrl(reviewUrl)
    }

    override fun showNoReviewsView() {
        hideLoading()
        llBookData.visibility = VISIBLE
        empityReviewMessage.visibility = VISIBLE
    }

    override fun showErrorMessage() {
        empityReviewMessage.visibility = VISIBLE
        empityReviewMessage.text = getString(R.string.error_loading_review)
    }

    override fun showLoading() {
        pgReview.visibility = VISIBLE
    }

    override fun hideLoading() {
        pgReview.visibility = GONE
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        menuFavorite = menu.getItem(0)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.favorite -> favoriteItem()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun favoriteItem() {
    }
}
