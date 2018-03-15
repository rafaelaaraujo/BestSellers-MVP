package com.bestsellers.favorite

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.bestsellers.R
import com.bestsellers.bookDetails.BookDetailsActivity
import com.bestsellers.data.BestSellersRepository
import com.bestsellers.data.model.Book
import com.bestsellers.util.BOOK
import com.bestsellers.util.launchActivity
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.empty_state_view.*

/**
 * Created by rafaela.araujo on 27/02/18.
 */
class FavoriteFragment : Fragment(), FavoriteContract.View {

    override lateinit var presenter: FavoriteContract.Presenter
    private var favoriteList: List<Book> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.activity_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = FavoritePresenter(this, BestSellersRepository(context = activity))
        loadRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        presenter.getFavoriteBooks()
    }

    private fun loadRecyclerView() {
        recyclerFavorite.layoutManager = GridLayoutManager(context, 2)
        recyclerFavorite.adapter = FavoriteAdapter(favoriteList, this::showBookDetails)
        empityStateLayout.visibility = GONE
    }

    override fun showErrorMessage() {
        empityStateLayout.visibility = VISIBLE
        txt_message_emptyState.text = getString(R.string.error_loading_data)
    }

    override fun showLoading() {
        progressFavorite.visibility = VISIBLE
    }

    override fun hideLoading() {
        progressFavorite.visibility = GONE
    }

    override fun showFavoriteBooks(list: List<Book>) {
        favoriteList = list
        loadRecyclerView()

        if (list.isEmpty()) {
            showEmptyStateMessage()
        }
    }

    private fun showEmptyStateMessage() {
        empityStateLayout.visibility = VISIBLE
        txt_message_emptyState.text = getString(R.string.empty_favorite_book_list)
    }

    private fun showBookDetails(book: Book) {
        activity?.launchActivity<BookDetailsActivity> { putExtra(BOOK, book) }
    }
}