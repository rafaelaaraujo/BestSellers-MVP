package com.bestsellers.bookGenres

import android.widget.Filter
import com.bestsellers.model.Genre

/**
 * Created by Rafaela Araujo
 * on 14/11/2017.
 */
class BookGenresFilter(private val genreList:List<Genre>, private val listener: (List<Genre>) -> Unit) : Filter() {

    override fun performFiltering(constraint: CharSequence): FilterResults {
        val filterResults = FilterResults()
        filterResults.count = genreList.size
        filterResults.values = genreList

        if (constraint.isNotEmpty()) {
            val tempList = ArrayList<Genre>()

            genreList.forEach {
                if (it.display_name.contains(constraint, true)) {
                    tempList.add(it)
                }
            }

            filterResults.count = tempList.size
            filterResults.values = tempList
        }

        return filterResults
    }

    override fun publishResults(query: CharSequence, results: FilterResults) {
        listener(results.values as List<Genre>)
    }

}