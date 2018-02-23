package com.bestsellers.bookDetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
import android.webkit.WebView
import com.bestsellers.model.Book
import com.bestsellers.util.loadUrl
import kotlinx.android.synthetic.main.activity_details.*
import android.webkit.WebViewClient
import com.bestsellers.R
import com.bestsellers.common.BaseActivity
import com.bestsellers.util.BOOK
import com.bestsellers.util.startBounceAnimation
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*

class BookDetailsActivity(private var menuFavorite: MenuItem) : BaseActivity(), BookDetailsContract.View, View.OnClickListener {

    override lateinit var presenter: BookDetailsContract.Presenter
    private var book: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        presenter = BookDetailsPresenter(this)

        book = intent.extras.getSerializable(BOOK) as? Book
        window.setFlags(FLAG_LAYOUT_NO_LIMITS, FLAG_LAYOUT_NO_LIMITS)
        setBookInformations()
    }

    private fun setBookInformations() {
        book?.apply {
            configureActionBar(title, toolbar)
            expandedImage.loadUrl(book_image)
            weeksOnList.text = getWeeksOnTheList(weeks_on_list)
            writer.text = contributor
            desc.text = description
        }
    }

    private fun getWeeksOnTheList(weeks_on_list: Int): String {
        return if (weeks_on_list <= 1) {
            "NEW THIS WEEK"
        } else {
            "$weeks_on_list WEEKS ON THE LIST"
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

    override fun onClick(view: View?) = startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(book?.amazon_product_url)))


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
