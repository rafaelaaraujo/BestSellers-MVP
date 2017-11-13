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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(bestSellerList[position], listener)

    override fun getItemCount(): Int = bestSellerList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Book, listener: (Book) -> Unit) = with(itemView) {
            bookTimeInList.text = getWeeksOnTheList(item.weeks_on_list)
            bookTittle.text = item.title
            bookAuthor.text = item.contributor
            bookDescription.text = item.description
            bookImage.loadUrl(item.book_image)
            setOnClickListener { listener(item) }
        }

        private fun getWeeksOnTheList(weeks_on_list: Int): String {
            return if(weeks_on_list <= 1){
                "NEW THIS WEEK"
            }else{
                "$weeks_on_list WEEKS ON THE LIST"
            }

        }
    }
}