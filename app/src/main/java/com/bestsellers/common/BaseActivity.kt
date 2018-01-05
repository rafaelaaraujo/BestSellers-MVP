package com.bestsellers.common

import android.support.v7.app.AppCompatActivity
import android.view.MenuItem

/**
 * Created by Rafaela Araujo
 * on 09/11/2017.
 */
abstract class BaseActivity: AppCompatActivity() {

    fun configureActionBar(newTitle: String) {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
            title = newTitle
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}