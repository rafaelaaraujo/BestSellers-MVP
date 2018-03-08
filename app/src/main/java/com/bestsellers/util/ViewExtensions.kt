package com.bestsellers.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import android.view.animation.AnimationUtils
import com.bestsellers.R


/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */

fun Activity.showSnackBar(text: String) {
    Snackbar.make(window.decorView, text, Snackbar.LENGTH_SHORT).show()
}

inline fun <reified T : Activity> Activity.launchActivity(sharedView: View? = null, noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.init()

    if (sharedView != null) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, sharedView, SHARED_ITEM_ID)
        startActivity(intent, options.toBundle())
        overridePendingTransition(0,0)
    } else {
        startActivity(intent)
    }
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



