package com.motasem.ziad.mylibrary.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.motasem.ziad.mylibrary.DetailsActivity

import com.motasem.ziad.mylibrary.R
import com.motasem.ziad.mylibrary.adapter.BooksAdapter
import com.motasem.ziad.mylibrary.adapter.CategoriesAdapter
import com.motasem.ziad.mylibrary.db.DatabaseHelper
import com.motasem.ziad.mylibrary.model.Categories
import com.motasem.ziad.mylibrary.model.SwipeToDeleteCallback
import kotlinx.android.synthetic.main.fragment_favorate.*

/**
 * A simple [Fragment] subclass.
 */
@Suppress("UNUSED_CHANGED_VALUE")
class FavorateFragment : Fragment(), BooksAdapter.onClick {
    lateinit var data: MutableList<Categories>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_favorate, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        val db = DatabaseHelper(activity!!)
        data = db.getAllFavorate()
        rvFavorate.layoutManager = LinearLayoutManager(activity)
        rvFavorate.setHasFixedSize(true)
        val favorateAdapter = CategoriesAdapter(activity!!, data, this)
        rvFavorate.adapter = favorateAdapter
        super.onActivityCreated(savedInstanceState)

        val swipeToDeleteCallback = object : SwipeToDeleteCallback(activity!!) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter: CategoriesAdapter = rvFavorate.adapter as CategoriesAdapter
                adapter.removeAt(viewHolder.adapterPosition)
                db.deleteCategories(viewHolder.adapterPosition)
            }

        }

        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(rvFavorate)
    }

    override fun onClickItem(position: Int) {
        val i = Intent(activity, DetailsActivity::class.java)
        i.putExtra("id", data[position].id)
        i.putExtra("name", data[position].name)
        i.putExtra("details", data[position].details)
        i.putExtra("img", data[position].img)
        startActivity(i)
    }


}
