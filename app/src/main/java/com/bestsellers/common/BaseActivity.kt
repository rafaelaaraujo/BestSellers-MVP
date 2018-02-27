package com.bestsellers.common

import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bestsellers.R

/**
 * Created by Rafaela Araujo
 * on 09/11/2017.
 */
abstract class BaseActivity : AppCompatActivity() {

    protected fun configureActionBar(newTitle: String) {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
            title = newTitle
        }
    }

    protected fun setToolbarIcon() {
        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayUseLogoEnabled(true)
            setLogo(R.drawable.ic_ny)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

}