package com.bestsellers.bestSellers

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View.GONE
import android.view.View.VISIBLE
import com.bestsellers.R
import com.bestsellers.bookDetails.BookDetailsActivity
import com.bestsellers.common.BaseActivity
import com.bestsellers.model.Book
import com.bestsellers.util.*
import kotlinx.android.synthetic.main.activity_best_sellers.*
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import kotlinx.android.synthetic.main.book_card_options.*

/**
 * Created by Rafaela
 * on 03/11/2017.
 */
class BestSellersActivity : BaseActivity(), BestSellersContract.View {

    override var presenter: BestSellersContract.Presenter = BestSellersPresenter(this)
    private var booksList = ArrayList<Book>()
    private val MAX_SCALE = 1.05f
    private val MIN_SCALE = 0.8f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_sellers)

        val listName = intent.extras.getString(GENRE_NAME)
        configureView(listName)

        presenter = BestSellersPresenter(this)
        presenter.requestBestSellers(listName)
    }

    private fun configureView(listName: String) {
        configureActionBar(listName, null)
        configureRecicleView()
        reviewButton.setOnClickListener { showBookDetails() }
        fabbuyButton.setOnClickListener { openBuyLink() }
        favoriteButton.setOnClickListener { favoriteBook() }
    }

    private fun favoriteBook() {
        favoriteButton.setImageDrawable(getFavoriteCorrectIcon())
        favoriteButton.startBounceAnimation()
    }

    private fun getFavoriteCorrectIcon() : Drawable? {
//        if (getCurrentBook().amazon_product_url))
        return ContextCompat.getDrawable(this, R.drawable.ic_favorite_selected)
    }

    private fun configureRecicleView() {
        bestSellersList.setItemTransformer(getScaleTransformation())
        bestSellersList.adapter = BestSellersAdapter(booksList)
    }

    private fun getScaleTransformation() =
            ScaleTransformer.Builder().apply {
                setMaxScale(MAX_SCALE)
                setMinScale(MIN_SCALE)
            }.build()


    private fun openBuyLink() = startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(getCurrentBook().amazon_product_url)))

    private fun showBookDetails() =
            launchActivity<BookDetailsActivity> { putExtra(BOOK, getCurrentBook()) }


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

}