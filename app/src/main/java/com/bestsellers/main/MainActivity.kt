package com.bestsellers.main

import android.os.Bundle
import com.bestsellers.R
import com.bestsellers.bookGenre.BookGenresFragment
import com.bestsellers.common.BaseActivity
import com.bestsellers.favorite.FavoriteFragment
import kotlinx.android.synthetic.main.main_activity.*

/**
 * Created by Rafaela Araujo
 * on 26/02/2018.
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportActionBar?.elevation = 0f

        setupViewPager()
        setToolbarIcon()
    }

    private fun setupViewPager() {
        pager.adapter = MainPageAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(pager)
    }
}