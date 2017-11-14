package com.bestsellers.genre

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.SearchView
import com.bestsellers.bestSellers.BestSellersActivity
import com.bestsellers.bestSellers.R
import com.bestsellers.bookDetails.GenreContract
import com.bestsellers.common.BaseActivity
import com.bestsellers.model.Genre
import com.bestsellers.util.Constants.Companion.GENRE_NAME
import com.bestsellers.util.launchActivity
import kotlinx.android.synthetic.main.activity_genre.*


/**
* Created by rafaela.araujo
* on 07/11/17.
*/

class GenreActivity : BaseActivity(), GenreContract.View, SearchView.OnQueryTextListener {

    override lateinit var presenter: GenreContract.Presenter
    private lateinit var adapter: GenreAdapter
    private var genreList = ArrayList<Genre>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)
        presenter = GenrePresenter(this)
        configureGridView()
    }

    private fun configureGridView() {
        genreGrid.layoutManager = GridLayoutManager(this, 2)
        adapter = GenreAdapter(genreList) {
            openListByGenre(it)
        }
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
        genreGrid.adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)
        configureSearchManeger(menu)
        return true
    }

    private fun configureSearchManeger(menu: Menu) {
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setOnQueryTextListener(this)

    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        adapter.filter.filter(p0)
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return false
    }


}