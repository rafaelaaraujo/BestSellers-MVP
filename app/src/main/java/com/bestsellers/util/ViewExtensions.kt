package com.bestsellers.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */

fun Activity.showSnackBar(view: View, text: String) {
    Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
}

fun Activity.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

inline fun <reified T : Activity> Activity.launchActivity(noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.init()
    startActivity(intent)
}

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

