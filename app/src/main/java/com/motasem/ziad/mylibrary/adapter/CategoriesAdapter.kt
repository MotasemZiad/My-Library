package com.motasem.ziad.mylibrary.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.motasem.ziad.mylibrary.R
import com.motasem.ziad.mylibrary.model.Categories
import kotlinx.android.synthetic.main.categories_item.view.*

class CategoriesAdapter(
    var context: Context,
    var data: MutableList<Categories>,
    var click: BooksAdapter.onClick
) : RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>(), Filterable {
    var filterListResult: MutableList<Categories>

    init {
        this.filterListResult = data
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.tvCategoryName
        val tvDetails = itemView.tvCategoryDetails
        val imgCategory = itemView.imgCategories as ImageView
        val cardCategory = itemView.cardCategories
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.categories_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return filterListResult.size
    }

    fun removeAt(position: Int) {
        filterListResult.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = filterListResult[position].name
        holder.tvDetails.text = filterListResult[position].details
        holder.imgCategory.setImageResource(filterListResult[position].img)
        holder.cardCategory.setOnClickListener {
            click.onClickItem(holder.adapterPosition)
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charString: CharSequence?): FilterResults {
                val charSearch = charString.toString()
                if (charSearch.isEmpty()) {
                    filterListResult = data
                } else {
                    val resultList = ArrayList<Categories>()
                    for (row in data) {
                        if (row.name!!.toLowerCase().contains(charSearch.toLowerCase())) {
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
                filterListResult = filterResults!!.values as MutableList<Categories>
                notifyDataSetChanged()
            }

        }
    }
}
