package com.bestsellers.genre

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import com.bestsellers.bestSellers.BestSellersActivity
import com.bestsellers.bestSellers.R
import com.bestsellers.bookDetails.GenreContract
import com.bestsellers.common.BaseActivity
import com.bestsellers.model.Genre
import com.bestsellers.util.Constants.Companion.GENRE_NAME
import com.bestsellers.util.launchActivity
import kotlinx.android.synthetic.main.activity_genre.*

/**
 * Created by rafaela.araujo on 07/11/17.
 */
class GenreActivity : BaseActivity(), GenreContract.View {

    override lateinit var presenter: GenreContract.Presenter
    private var genreList = ArrayList<Genre>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)
        presenter = GenrePresenter(this)
        configureGridView()
    }

    private fun configureGridView() {
        genreGrid.layoutManager = GridLayoutManager(this, 2)
        genreGrid.adapter = GenreAdapter(genreList) {
            openListByGenre(it)
        }
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
}