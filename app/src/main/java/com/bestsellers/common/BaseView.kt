package com.bestsellers.common

/**
* Created by Rafaela Araujo
* on 06/10/2017.
*/
interface BaseView<out T : BasePresenter<*>> {

    val presenter: T

    fun showErrorMessage()

    fun showLoading()

    fun hideLoading()
}