package com.bestsellers.bookDetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.webkit.WebView
import com.bestsellers.model.Book
import com.bestsellers.util.loadUrl
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.best_seller_item.*
import android.webkit.WebViewClient
import com.bestsellers.R
import com.bestsellers.common.BaseActivity
import com.bestsellers.util.BOOK
import com.bestsellers.util.launchActivity

class BookDetailsActivity : BaseActivity(), BookDetailsContract.View, View.OnClickListener {

    override var presenter: BookDetailsContract.Presenter = BookDetailsPresenter(this)
    private var book: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        presenter = BookDetailsPresenter(this)

        book = intent.extras.getSerializable(BOOK) as? Book
        book?.title?.let {
            presenter.getBookReview(it)
            configureActionBar(it)
        }
        setBookInformations()
    }

    private fun setBookInformations() {
        book?.apply {
            bookTittle.text = title
            bookAuthor.text = contributor
            bookImage.loadUrl(book_image)
        }

        btnBuyBook.setOnClickListener(this)
        buyButton.setOnClickListener(this)
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

}
