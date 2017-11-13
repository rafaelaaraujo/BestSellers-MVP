package com.bestsellers.bookDetails

import com.bestsellers.common.BasePresenter
import com.bestsellers.common.BaseView
import com.bestsellers.model.BookReview

/**
 * Created by Rafaela Araujo
 * on 03/11/2017.
 */
class BookDetailsContract {

    interface View : BaseView<Presenter> {
        fun loadBookReview(reviewUrl: String)

        fun showNoReviewsView()
    }

    interface Presenter : BasePresenter {
        fun getBookReview(tittle:String)
    }
}