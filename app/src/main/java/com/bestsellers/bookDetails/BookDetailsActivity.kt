package com.bestsellers.bookDetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.VISIBLE
import com.bestsellers.bestSellers.R
import com.bestsellers.model.Book
import com.bestsellers.model.BookReview
import com.bestsellers.util.Constants.Companion.BOOK
import com.bestsellers.util.loadUrl
import com.bestsellers.util.showSnackBar
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.best_seller_item.*
import android.webkit.WebViewClient
import com.bestsellers.common.BaseActivity


class BookDetailsActivity : BaseActivity(), BookDetailsContract.View {

    override lateinit var presenter: BookDetailsContract.Presenter
    private lateinit var book: Book

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        presenter = BookDetailsPresenter(this)
        book = intent.extras.getSerializable(BOOK) as Book
        configureActionBar(book.title)
        setBookInformations()
    }

    private fun setBookInformations() {
        bookTittle.text = book.title
        bookAuthor.text = book.contributor
        bookDescription.text = book.description
        bookImage.loadUrl(book.book_image)

        buyButton.setOnClickListener { view ->
            showSnackBar(view, "buy button clicked")
        }
        presenter.getBookReview(book.title)
    }

    override fun loadBookReview(review: BookReview) {
        reviewWebView.webViewClient = WebViewClient()
        reviewWebView.loadUrl(review.url)
    }

    override fun showEmpityReviewMessage() {
        empityReviewMessage.visibility = VISIBLE
    }

    override fun loadEmpytReviewsMessage() {
    }


    override fun showErrorMessage() {

    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

}
