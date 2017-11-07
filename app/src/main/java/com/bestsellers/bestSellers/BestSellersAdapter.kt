package com.bestsellers.bestSellers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bestsellers.model.Book
import com.bestsellers.util.loadUrl
import kotlinx.android.synthetic.main.best_seller_item.view.*

/**
 * Created by rafaela.araujo on 07/11/17.
 */
class BestSellersAdapter(
        private val bestSellerList: List<Book>,
        private val listener: (Book) -> Unit) : RecyclerView.Adapter<BestSellersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.best_seller_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bestSellerList[position], listener)
    }

    override fun getItemCount(): Int {
        return bestSellerList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Book, listener: (Book) -> Unit) = with(itemView) {
            bookTittle.text = item.title
            bookAuthor.text = "by "+item.author
            bookPublisher.text = item.publisher
            bookImage.loadUrl(item.book_image)
            setOnClickListener { listener(item) }
        }
    }
}