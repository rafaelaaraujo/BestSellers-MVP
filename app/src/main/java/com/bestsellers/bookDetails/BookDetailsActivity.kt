package com.bestsellers.bookDetails

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bestsellers.R
import com.bestsellers.common.BaseActivity
import com.bestsellers.model.Book
import com.bestsellers.model.BookReviewCount
import com.bestsellers.util.BOOK
import com.bestsellers.util.loadUrl
import com.bestsellers.util.openUrlInBrowser
import kotlinx.android.synthetic.main.details_activity.*

class BookDetailsActivity : BaseActivity(), BookDetailsContract.View {
    
    override lateinit var presenter: BookDetailsContract.Presenter
    private var book: Book? = null
    private lateinit var menuFavorite: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)
        hideStatusBar()
        presenter = BookDetailsPresenter(this)
        book = intent.extras.getSerializable(BOOK) as? Book
        setBookInformation()
    }

    private fun setBookInformation() {
        book?.apply {
            presenter.getBookReviewCount(isbns[0].isbn10)
            configureActionBar(title)
            weeksOnList.text = getWeeksOnTheList(weeks_on_list)
            titleBook.text = title
            writer.text = contributor
            desc.text = description
            txtIsbn13.text = getString(R.string.isbn13, isbns[0].isbn13)
            txtIsbn10.text = getString(R.string.isbn10, isbns[0].isbn10)
            txtPublisher.text = getString(R.string.publisher, publisher)
            rankPosition.text = rank.toString()
            image.loadUrl(book_image)
        }

        shopButton.setOnClickListener { openUrlInBrowser(book?.amazon_product_url) }
    }

    private fun getWeeksOnTheList(weeks_on_list: Int): String {
        return if (weeks_on_list <= 1) {
            getString(R.string.new_this_week)
        } else {
            getString(R.string.weeks_on_list, weeks_on_list)
        }
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

    override fun showErrorMessage() {

    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun loadBookReviewCount(bookReviewCount: BookReviewCount) {
        reviewsRatingBar.rating = bookReviewCount.average_rating
    }

    override fun showNoReviewsView() {

    }
}
