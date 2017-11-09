package com.bestsellers.bookDetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bestsellers.bestSellers.R
import com.bestsellers.model.Book
import com.bestsellers.model.BookReview
import com.bestsellers.util.loadUrl
import com.bestsellers.util.showSnackBar
import kotlinx.android.synthetic.main.activity_best_seller_details.*
import kotlinx.android.synthetic.main.content_news_details.*
import android.webkit.WebView
import android.webkit.WebViewClient


class BookDetailsActivity : AppCompatActivity(), BookDetailsContract.View {

    override lateinit var presenter: BookDetailsContract.Presenter
    private lateinit var book: Book

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_seller_details)
        presenter = BookDetailsPresenter(this)
        book = intent.extras.getSerializable("book") as Book
        setBookInformations()
    }

    private fun setBookInformations() {
        setSupportActionBar(toolbar)
        image.loadUrl(book.book_image)
        collapsingToolbar.title = book.title
        collapsingToolbar.subtitle = book.contributor

        fab.setOnClickListener { view ->
            showSnackBar(view, "share button clicked")
        }

        presenter.getBookReview(book.title)
    }

    override fun loadBookReview(review: BookReview) {
        reviewWebView.webViewClient = WebClient()
        reviewWebView.settings.loadsImagesAutomatically = false
        reviewWebView.loadUrl(review.url)
    }

    override fun loadEmpytReviewsMessage() {
    }


    override fun showErrorMessage() {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    inner class WebClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }

        override fun onPageFinished(view: WebView, url: String) {
            view.loadUrl("javascript:(function() { " +
                    "document.getElementById('singleAd')[0].style.display='none';})()");

            view.loadUrl("javascript:(function() { " +
                    "document.getElementById('navigation tabsContainer')[0].style.display='none';})()");

        }

    }
}
