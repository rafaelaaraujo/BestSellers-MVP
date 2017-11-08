package com.bestsellers.bookDetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bestsellers.bestSellers.R
import com.bestsellers.model.Book
import com.bestsellers.util.loadUrl
import com.bestsellers.util.showSnackBar
import kotlinx.android.synthetic.main.activity_best_seller_details.*
import kotlinx.android.synthetic.main.content_news_details.*

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
        publisher.text = book.publisher
        description.text = book.description
        contributorNote.text = book.contributor_note
        fristCapterLink.text = book.first_chapter_link

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
