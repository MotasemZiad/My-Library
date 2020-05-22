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
import kotlinx.android.synthetic.main.fragment_science.*

/**
 * A simple [Fragment] subclass.
 */
class LanguageFragment : Fragment(), BooksAdapter.onClick {
    lateinit var data: MutableList<Categories>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_language, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        data = mutableListOf<Categories>()
        data.add(
            Categories(
                1,
                "Arabic Learning 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.arabic_book
            )
        )
        data.add(
            Categories(
                2,
                "English Learning nd2 Edition",
                getString(R.string.category_datails),
                R.drawable.english
            )
        )
        data.add(
            Categories(
                3,
                "France Learning 4th Edition",
                getString(R.string.category_datails),
                R.drawable.france
            )
        )
        data.add(
            Categories(
                4,
                "Chinese 1st Edition",
                getString(R.string.category_datails),
                R.drawable.chinese
            )
        )
        data.add(
            Categories(
                5,
                "Germany 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.germany
            )
        )
        data.add(
            Categories(
                6,
                "Turkey Learning 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.turkiye
            )
        )
        data.add(
            Categories(
                7,
                "Spanish 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_spanish
            )
        )
        data.add(
            Categories(
                8,
                "Austria 4th Edition",
                getString(R.string.category_datails),
                R.drawable.ic_detective_story
            )
        )
        data.add(
            Categories(
                9,
                "Latinos 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.latinos
            )
        )
        data.add(
            Categories(
                10,
                "Portugal 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_abacus
            )
        )
        data.add(
            Categories(
                11,
                "Italy 1st Edition",
                getString(R.string.category_datails),
                R.drawable.ic_author
            )
        )
        data.add(
            Categories(
                12,
                "Ruby 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_books_bio
            )
        )
        data.add(
            Categories(
                13,
                "Rola Maria Edition",
                getString(R.string.category_datails),
                R.drawable.ic_books
            )
        )

        rvLanguage.layoutManager = LinearLayoutManager(context)
        rvLanguage.setHasFixedSize(true)
        val LanguageAdapter = CategoriesAdapter(context!!, data, this)
        rvLanguage.adapter = LanguageAdapter
        super.onActivityCreated(savedInstanceState)
    }

    override fun onClickItem(position: Int) {
        val i =  Intent(activity, DetailsActivity::class.java)
        i.putExtra("id", data[position].id)
        i.putExtra("name", data[position].name)
        i.putExtra("details", data[position].details)
        i.putExtra("img", data[position].img)
        startActivity(i)
    }


}
