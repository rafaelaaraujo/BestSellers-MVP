package com.bestsellers.genre

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.bestsellers.bestSellers.R
import com.bestsellers.model.Genre
import kotlinx.android.synthetic.main.genre_item.view.*

/**
 * Created by rafaela.araujo on 07/11/17.
 */
class GenreAdapter(private var genreList: List<Genre>, private val listener: (Genre) -> Unit) :
        RecyclerView.Adapter<GenreAdapter.ViewHolder>(), Filterable {

    val filter:GenreFilter

    init {
        filter = GenreFilter()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.genre_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(genreList[position], listener)

    override fun getItemCount(): Int = genreList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Genre, listener: (Genre) -> Unit) = with(itemView) {
            genreTittle.text = item.display_name
            genreUpdated.text = "Updated ${item.updated}"
            setOnClickListener { listener(item) }
        }
    }


    override fun getFilter(): Filter {
        return filter
    }

    inner class GenreFilter : Filter() {

        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filterResults = Filter.FilterResults()
            if (constraint.isNotEmpty()) {
                val tempList = ArrayList<Genre>()
                genreList.forEach({
                    if (it.display_name.contains(constraint, true)) {
                        tempList.add(it)
                    }
                })
                filterResults.count = tempList.size
                filterResults.values = tempList
            }else{
                filterResults.count = genreList.size
                filterResults.values = genreList
            }

            return filterResults
        }

        override fun publishResults(p0: CharSequence, p1: FilterResults) {
            genreList = p1.values as List<Genre>
            notifyDataSetChanged()
        }

    }

}