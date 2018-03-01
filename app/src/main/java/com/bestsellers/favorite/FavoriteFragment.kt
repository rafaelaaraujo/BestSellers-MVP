package com.bestsellers.favorite

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bestsellers.R

/**
 * Created by rafaela.araujo on 27/02/18.
 */
class FavoriteFragment : Fragment(), FavoriteContract.View {

    override var presenter: FavoriteContract.Presenter = FavoritePresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.activity_favorite, container, false)
    }

    override fun showErrorMessage() {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

}