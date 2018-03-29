package com.bestsellers.util.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.bestsellers.R
import com.bestsellers.util.BounceInterpolator
import com.bestsellers.util.SHARED_ITEM_ID


/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */

fun Activity.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

inline fun <reified T : Activity> Activity.launchActivity(sharedView: View? = null, noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.init()

    if (sharedView != null) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, sharedView, SHARED_ITEM_ID)
        startActivity(intent, options.toBundle())
        overridePendingTransition(0, 0)
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

/**
 * Retrieve property from intent
 */
fun <T : Any> Activity.argument(key: String) = lazy { intent.extras?.get(key) as T }




