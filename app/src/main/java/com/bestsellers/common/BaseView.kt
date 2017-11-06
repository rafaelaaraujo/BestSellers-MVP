package com.bestsellers.common

/**
* Created by Rafaela Araujo
* on 06/10/2017.
*/
interface BaseView<T> {

    var presenter: T

    fun showErrorMessage()

    fun showLoading()

    fun hideLoading()

}