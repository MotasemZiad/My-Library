package com.motasem.ziad.mylibrary.adapter


import AddBook
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.motasem.ziad.mylibrary.R
import kotlinx.android.synthetic.main.categories_item.view.*

class AddBookAdapter(
    var context: Context,
    var data: MutableList<AddBook>,
    var click: BooksAdapter.onClick
) : RecyclerView.Adapter<AddBookAdapter.MyViewHolder>() {

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
        return data.size
    }

    fun removeAt(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = data[position].name
        holder.tvDetails.text = data[position].details
        holder.imgCategory.setImageURI(Uri.parse(data[position].img))
        holder.cardCategory.setOnClickListener {
            click.onClickItem(holder.adapterPosition)
        }
    }
}