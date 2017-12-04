package com.bestsellers.bookGenres

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.SearchView
import com.bestsellers.bestSellers.BestSellersActivity
import com.bestsellers.bestSellers.R
import com.bestsellers.bookDetails.BookGenresContract
import com.bestsellers.common.BaseActivity
import com.bestsellers.model.Genre
import com.bestsellers.util.GENRE_NAME
import com.bestsellers.util.launchActivity
import kotlinx.android.synthetic.main.activity_genre.*


/**
* Created by rafaela.araujo
* on 07/11/17.
*/

class BookGenresActivity : BaseActivity(), BookGenresContract.View, SearchView.OnQueryTextListener {

    override lateinit var presenter: BookGenresContract.Presenter
    private lateinit var adapter: BookGenresAdapter
    private var genreList = ArrayList<Genre>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)
        presenter = BookGenresPresenter(this)
        configureGridView()
        presenter.requestGenreList()
    }

    private fun configureGridView() {
        genreGrid.layoutManager = GridLayoutManager(this, 2)
        adapter = BookGenresAdapter(genreList, this::openListByGenre)
        genreGrid.adapter = adapter
    }

    private fun openListByGenre(genre: Genre) {
        launchActivity<BestSellersActivity> {
            putExtra(GENRE_NAME, genre.list_name)
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        configureSearchManager(menu)
        return true
    }

    private fun configureSearchManager(menu: Menu) {
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        adapter.filter.filter(query)
        return true
    }

    override fun onQueryTextChange(query: String): Boolean {
        adapter.filter.filter(query)
        return false
    }
}