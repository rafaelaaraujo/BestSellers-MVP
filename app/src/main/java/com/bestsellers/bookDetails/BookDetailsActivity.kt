package com.bestsellers.bookDetails

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bestsellers.R
import com.bestsellers.common.BaseActivity
import com.bestsellers.data.BestSellersData
import com.bestsellers.model.Book
import com.bestsellers.model.BookReviewCount
import com.bestsellers.util.*
import kotlinx.android.synthetic.main.details_activity.*


class BookDetailsActivity : BaseActivity(), BookDetailsContract.View {

    override lateinit var presenter: BookDetailsContract.Presenter
    private var book: Book? = null
    private lateinit var menuFavorite: MenuItem
    private val menuItemPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.details_activity)
        presenter = BookDetailsPresenter(this, BestSellersData(context = this))
        book = intent.extras.getSerializable(BOOK) as? Book
        setBookInformation()
        super.onCreate(savedInstanceState)
    }

    private fun setBookInformation() {
        book?.apply {
            configureActionBar(title)
            presenter.getBookReviewCount(getIsbn())
            txtIsbn10.text = getString(R.string.isbn10, getIsbn())
            weeksOnList.text = getWeeksOnTheList(this@BookDetailsActivity)
            titleBook.text = title
            writer.text = contributor
            desc.text = description
            txtPublisher.text = getString(R.string.publisher, publisher)
            rankPosition.text = rank.toString()
            image.loadUrl(book_image)
            shopButton.setOnClickListener { openUrlInBrowser(amazon_product_url) }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        menuFavorite = menu.getItem(menuItemPosition)
        presenter.verifyIsFavoriteBook(book?.title)
        return true
    }

    override fun updateStatus(isBookFavorite: Boolean) {
        menuFavorite.apply {
            setIcon(if (isBookFavorite) R.drawable.ic_favorite_selected else R.drawable.ic_favorite_unselected)
            title = if (isBookFavorite) getString(R.string.not_favorite) else getString(R.string.favorite)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.favorite -> favoriteItem()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun favoriteItem() {
        book?.let { presenter.changeBookStatus(it, menuFavorite.title == getString(R.string.favorite)) }
    }

    override fun showErrorMessage() {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showFavoriteMessage() {
        showSnackBar(getString(R.string.favorite_message))
    }

    override fun showRemoveFavoriteBookMessage() {
        showSnackBar(getString(R.string.remove_favorite_message))
    }

    override fun loadBookReviewCount(bookReviewCount: BookReviewCount) {
        reviewsRatingBar.rating = bookReviewCount.average_rating
    }
}
