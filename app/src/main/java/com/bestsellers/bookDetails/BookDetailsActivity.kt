package com.bestsellers.bookDetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bestsellers.bestSellers.R
import com.bestsellers.model.Book
import com.bestsellers.util.loadUrl
import com.bestsellers.util.showSnackBar
import kotlinx.android.synthetic.main.activity_best_seller_details.*

class BookDetailsActivity : AppCompatActivity(), BookDetailsContract.View {

    override lateinit var presenter: BookDetailsContract.Presenter
    private lateinit var book: Book

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_seller_details)
        presenter = BookDetailsPresenter(this)
        book = intent.extras.getSerializable("book") as Book
        configureView()
    }

    private fun configureView() {
        setSupportActionBar(toolbar)
        image.loadUrl(book.book_image)
        collapsingToolbar.title = book.title
        collapsingToolbar.subtitle = "by " + book.author
        fab.setOnClickListener { view ->
            showSnackBar(view, "share button clicked")
        }
    }

    override fun showErrorMessage() {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

}
