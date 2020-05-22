package com.motasem.ziad.mylibrary.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.motasem.ziad.mylibrary.R
import com.motasem.ziad.mylibrary.model.Books
import kotlinx.android.synthetic.main.books_item.view.*

class BooksAdapter(var activity: Activity, var data: MutableList<Books>, val click: onClick) :
    RecyclerView.Adapter<BooksAdapter.MyViewHolder>(), Filterable {
    var filterListResult: MutableList<Books> = data

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTypeOfBooks = itemView.tvTypeOfBooks
        val imgBook = itemView.imgBook as ImageView
        val card = itemView.cardBooks
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(activity).inflate(R.layout.books_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return filterListResult.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvTypeOfBooks.text = filterListResult[position].type
        holder.imgBook.setImageResource(filterListResult[position].image)
        holder.card.setOnClickListener {
            click.onClickItem(holder.adapterPosition)
        }
    }

    interface onClick {
        fun onClickItem(position: Int)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charString: CharSequence?): FilterResults {
                val charSearch = charString.toString()
                if (charSearch.isEmpty()) {
                    filterListResult = data
                } else {
                    val resultList = ArrayList<Books>()
                    for (row in data) {
                        if (row.type.toLowerCase().contains(charSearch.toLowerCase())) {
                            resultList.add(row)
                        }
                    }
                    filterListResult = resultList
                }
                val filterResults = Filter.FilterResults()
                filterResults.values = filterListResult
                return filterResults
            }

            override fun publishResults(
                charSequence: CharSequence?,
                filterResults: FilterResults?
            ) {
                filterListResult = filterResults!!.values as MutableList<Books>
                notifyDataSetChanged()
            }

        }
    }

}
