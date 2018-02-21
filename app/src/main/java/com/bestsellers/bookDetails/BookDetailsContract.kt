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

        /**
         * show review from selected book
         * @param reviewUrl
         */
        fun loadBookReview(reviewUrl: String)

        /**
         * show user message that the book has no reviews
         */
        fun showNoReviewsView()
    }

    interface Presenter : BasePresenter {

        /**
         * request book review from server
         * @param tittle from book
         */
        fun getBookReview(tittle: String)
    }
}