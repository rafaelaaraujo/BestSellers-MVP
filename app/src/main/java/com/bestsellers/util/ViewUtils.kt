package com.bestsellers.util

import android.app.Activity
import android.support.design.widget.Snackbar
import android.view.View

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */

fun Activity.showSnackBar(view: View, text:String){
    Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
}