package com.bestsellers.bestSellers

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import com.bestsellers.R
import com.bestsellers.bookdetails.BookDetailsActivity
import com.bestsellers.common.BaseActivity
import com.bestsellers.data.model.Book
import com.bestsellers.util.*
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import kotlinx.android.synthetic.main.activity_best_sellers.*
import kotlinx.android.synthetic.main.book_card_options.*
import org.koin.android.ext.android.inject

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BestSellersActivity : BaseActivity(), BestSellersContract.View, DiscreteScrollView.OnItemChangedListener<BestSellersAdapter.ViewHolder> {

    override val presenter : BestSellersContract.Presenter by inject()
    private var booksList = ArrayList<Book>()
    private val maxScale = 1.05f
    private val minScale = 0.8f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_sellers)
        presenter.view = this
        presenter.requestBestSellers(intent?.extras?.getString(GENRE_NAME)?: "")
        configureView(intent.extras.getString(DISPLAY_NAME))
    }

    private fun configureView(listName: String) {
        configureActionBar(listName)
        configureBestSellersList()
        datailsButton.setOnClickListener { showBookDetails() }
        fabbuyButton.setOnClickListener { openUrlInBrowser(getCurrentBook().amazon_product_url) }
        favoriteButton.setOnClickListener { favoriteBook(getCurrentBook()) }
    }

    private fun favoriteBook(currentBook: Book) {
        favoriteButton.startBounceAnimation()
        presenter.changeBookStatus(currentBook, favoriteButton.isChecked)
    }

    private fun configureBestSellersList() {
        bestSellersList.setItemTransformer(ScaleTransformer.Builder()
                .setMaxScale(maxScale)
                .setMinScale(minScale)
                .build())

        bestSellersList.adapter = BestSellersAdapter(booksList, this::showBookDetails)
        bestSellersList.addOnItemChangedListener(this)
    }

    private fun showBookDetails() {
        launchActivity<BookDetailsActivity>(bestSellersList.rootView.findViewById(R.id.bookImage)) {
            putExtra(BOOK, getCurrentBook())
        }
    }

    override fun showErrorMessage() {
        hideLoading()
        errorMessage.visibility = VISIBLE
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
        cardOptions.visibility = VISIBLE
    }

    private fun getCurrentBook() = booksList[bestSellersList.currentItem]

    override fun onCurrentItemChanged(viewHolder: BestSellersAdapter.ViewHolder?, position: Int) {
        if (position != -1)
            presenter.verifyIsFavoriteBook(getCurrentBook())
    }

    override fun changeFavoriteButton(isfavoriteBook: Boolean) {
        favoriteButton.isChecked = isfavoriteBook
    }

    override fun showFavoriteBookMessage() {
        showToast(getString(R.string.favorite_message))
    }

    override fun showRemoveFavoriteBookMessage() {
        showToast(getString(R.string.remove_favorite_message))
    }

    override fun onResume() {
        super.onResume()
        if (booksList.isNotEmpty())
            presenter.verifyIsFavoriteBook(getCurrentBook())
    }

}