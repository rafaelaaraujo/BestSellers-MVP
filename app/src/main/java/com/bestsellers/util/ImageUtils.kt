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

inline fun ImageView.loadUrl(url: String, callback: KCallback.() -> Unit) {
    Picasso.with(this.context).load(url).placeholder(ContextCompat.getDrawable(this.context,R.drawable.ic_library_books)).intoWithCallback(this, callback)
}

inline fun RequestCreator.intoWithCallback(target: ImageView, callback: KCallback.() -> Unit) {
    this.into(target, KCallback().apply(callback))
}

class KCallback : Callback {

    private var onSuccess: (() -> Unit)? = null
    private var onError: (() -> Unit)? = null

    override fun onSuccess() {
        onSuccess?.invoke()
    }

    override fun onError() {
        onError?.invoke()
    }

    fun onSuccess(function: () -> Unit) {
        this.onSuccess = function
    }

    fun onError(function: () -> Unit) {
        this.onError = function
    }
}

