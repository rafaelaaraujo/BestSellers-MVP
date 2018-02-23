package com.bestsellers.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.design.widget.Snackbar
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.bestsellers.R

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */

fun Activity.showSnackBar(view: View, text: String) {
    Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
}

fun Activity.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

inline fun <reified T : Activity> Activity.launchActivity(noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.init()
    startActivity(intent)
}

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

fun View.startBounceAnimation() {
    val myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce)
    val interpolator = BounceInterpolator(0.2, 20.0)
    myAnim.interpolator = interpolator

    this.startAnimation(myAnim)
}

fun Activity.openUrlInBrowser(url: String?) {
    if (url != null) this.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}



