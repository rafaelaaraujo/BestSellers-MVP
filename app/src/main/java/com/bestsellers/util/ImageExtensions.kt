package com.bestsellers.util

import android.support.v4.content.ContextCompat
import android.widget.ImageView
import com.bestsellers.bestSellers.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

/**
 * Created by rafaela.araujo on 07/11/17.
 */

fun ImageView.loadUrl(url: String) {
    Picasso.with(this.context).load(url).placeholder(ContextCompat.getDrawable(this.context,R.drawable.ic_library_books)).into(this)
}


