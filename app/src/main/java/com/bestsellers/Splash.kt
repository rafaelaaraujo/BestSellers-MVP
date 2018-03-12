package com.bestsellers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bestsellers.main.MainActivity
import com.bestsellers.util.launchActivity
import kotlinx.android.synthetic.main.activity_splash.*


private class Splash : AppCompatActivity() {

    val ANIN_DURATION  = 2000
    val ANIN_DELAY  = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        configurePathView()
    }

    private fun configurePathView() {
        pathView.pathAnimator.apply {
            delay(ANIN_DELAY)
            duration(ANIN_DURATION)
            listenerEnd { initGenreActivity()}
            start()
        }
    }

    private fun initGenreActivity() {
        finish()
        launchActivity<MainActivity>()
    }
}
