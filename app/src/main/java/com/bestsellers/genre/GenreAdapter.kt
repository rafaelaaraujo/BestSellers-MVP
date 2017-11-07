package com.bestsellers.genre

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bestsellers.bestSellers.R
import com.bestsellers.model.Genre
import kotlinx.android.synthetic.main.genre_item.view.*

/**
 * Created by rafaela.araujo on 07/11/17.
 */
class GenreAdapter(
        private val genreList: List<Genre>,
        private val listener: (Genre) -> Unit) : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.genre_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(genreList[position], listener)
    }

    override fun getItemCount(): Int {
        return genreList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Genre, listener: (Genre) -> Unit) = with(itemView) {
            genreTittle.text = item.display_name
            genreUpdated.text = "Updated "+item.updated.toLowerCase()
            setOnClickListener { listener(item) }
        }
    }
}