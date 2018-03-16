package com.bestsellers

import android.app.Application
import android.content.Context

import com.bestsellers.di.appModules
import org.koin.android.ext.android.startKoin
class BestSellersApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
        startKoin(this, appModules)
    }

    companion object {
        var context: Context? = null
    }

}