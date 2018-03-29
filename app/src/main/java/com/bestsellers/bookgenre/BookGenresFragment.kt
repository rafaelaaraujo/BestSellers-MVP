package com.bestsellers.bookgenre

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView.AdapterDataObserver
import android.support.v7.widget.SearchView
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import com.bestsellers.R
import com.bestsellers.bestsellers.BestSellersActivity
import com.bestsellers.bookdetails.BookGenresContract
import com.bestsellers.data.model.Genre
import com.bestsellers.util.DISPLAY_NAME
import com.bestsellers.util.GENRE_NAME
import com.bestsellers.util.ext.launchActivity
import kotlinx.android.synthetic.main.activity_genre.*
import org.koin.android.ext.android.inject


/**
 * Created by rafaela.araujo
 * on 07/11/17.
 */

class BookGenresFragment : Fragment(), BookGenresContract.View, SearchView.OnQueryTextListener {

    override val presenter: BookGenresContract.Presenter by inject()
    private lateinit var adapter: BookGenresAdapter
    private var genreList = ArrayList<Genre>()
    private var searchView: SearchView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        presenter.view = this
        return inflater.inflate(R.layout.activity_genre, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.requestGenreList()
        configureGridView()
    }

    private fun configureGridView() {
        genreGrid.layoutManager = LinearLayoutManager(activity)
        adapter = BookGenresAdapter(genreList, this::openListByGenre)
        adapter.registerAdapterDataObserver(observer)
        genreGrid.adapter = adapter
    }

    private val observer: AdapterDataObserver = object : AdapterDataObserver() {
        override fun onChanged() {
            super.onChanged()
            checkAdapterIsEmpty()
        }
    }

    private fun checkAdapterIsEmpty() {
        genreNotFoundMessge.visibility = if (adapter.itemCount == 0) VISIBLE else GONE
    }

    private fun openListByGenre(genre: Genre) {
        activity?.launchActivity<BestSellersActivity> {
            putExtra(GENRE_NAME, genre.list_name)
            putExtra(DISPLAY_NAME, genre.display_name)
        }
    }

    override fun showErrorMessage() {
        hideLoading()
    }

    override fun showLoading() {
        progressGenre.visibility = VISIBLE
    }

    override fun hideLoading() {
        progressGenre.visibility = GONE
    }

    override fun showGenreList(genreList: List<Genre>) {
        hideLoading()
        this.genreList.addAll(genreList)
        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
        configureSearchView(menu)
    }

    private fun configureSearchView(menu: Menu) {
        searchView = menu.findItem(R.id.search).actionView as? SearchView
        searchView?.setOnQueryTextListener(this)
        searchView?.clearFocus()
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        searchView?.clearFocus()
        return submitQuery(query)
    }

    override fun onQueryTextChange(query: String): Boolean {
        return submitQuery(query)
    }

    private fun submitQuery(query: String): Boolean {
        adapter.filter.filter(query)
        return true
    }

    override fun onPause() {
        super.onPause()
        searchView?.clearFocus()
    }
}