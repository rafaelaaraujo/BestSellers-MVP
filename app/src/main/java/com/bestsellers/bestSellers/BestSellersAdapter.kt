package com.bestsellers.bestSellers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bestsellers.R
import com.bestsellers.model.Book
import com.bestsellers.util.loadUrl
import kotlinx.android.synthetic.main.best_seller_item.view.*

/**
 * Created by rafaela.araujo on 07/11/17.
 */
class BestSellersAdapter(
        private val bestSellerList: List<Book>) :
        RecyclerView.Adapter<BestSellersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.best_seller_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(bestSellerList[position])

    override fun getItemCount(): Int = bestSellerList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal fun bind(item: Book) = with(itemView) {
            bookTittle.text = item.title
            bookAuthor.text = item.contributor
            rankPosition.text = item.rank.toString()
            bookImage.loadUrl(item.book_image)
        }
    }
}