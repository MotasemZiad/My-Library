package com.motasem.ziad.mylibrary.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.motasem.ziad.mylibrary.DetailsActivity

import com.motasem.ziad.mylibrary.R
import com.motasem.ziad.mylibrary.adapter.BooksAdapter
import com.motasem.ziad.mylibrary.adapter.CategoriesAdapter
import com.motasem.ziad.mylibrary.model.Categories
import kotlinx.android.synthetic.main.fragment_language.*
import kotlinx.android.synthetic.main.fragment_quran.*
import kotlinx.android.synthetic.main.fragment_science.*

/**
 * A simple [Fragment] subclass.
 */
class QuranFragment : Fragment(), BooksAdapter.onClick {
    lateinit var data: MutableList<Categories>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_quran, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        data = mutableListOf<Categories>()
        data.add(
            Categories(
                1,
                "The Holy Qura'n 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_books
            )
        )
        data.add(
            Categories(
                2,
                "Religion nd2 Edition",
                getString(R.string.category_datails),
                R.drawable.ic_classroom
            )
        )
        data.add(
            Categories(
                3,
                "Some religious 4th Edition",
                getString(R.string.category_datails),
                R.drawable.biology
            )
        )
        data.add(
            Categories(
                4,
                "The secret of Qura'n 1st Edition",
                getString(R.string.category_datails),
                R.drawable.ic_quran
            )
        )
        data.add(
            Categories(
                5,
                "Islam 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_quran1
            )
        )
        data.add(
            Categories(
                6,
                "Islam Learning 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.biology
            )
        )
        data.add(
            Categories(
                7,
                "Interruption 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.bool
            )
        )
        data.add(
            Categories(
                8,
                "The Lord of the rings 4th Edition",
                getString(R.string.category_datails),
                R.drawable.bee_logo
            )
        )
        data.add(
            Categories(
                9,
                "Some of learning 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_drama
            )
        )
        data.add(
            Categories(
                10,
                "Shareeia 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_biography
            )
        )
        data.add(
            Categories(
                11,
                "Kurulus Osman 1st Edition",
                getString(R.string.category_datails),
                R.drawable.ic_quran
            )
        )
        data.add(
            Categories(
                12,
                "Allah 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.quran_book
            )
        )
        data.add(
            Categories(
                13,
                "The world under Islam 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_quran1
            )
        )

        rvQuran.layoutManager = LinearLayoutManager(context)
        rvQuran.setHasFixedSize(true)
        val quranAdapter = CategoriesAdapter(context!!, data, this)
        rvQuran.adapter = quranAdapter
        super.onActivityCreated(savedInstanceState)
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
