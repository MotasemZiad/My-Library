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
import kotlinx.android.synthetic.main.fragment_engineering.*
import kotlinx.android.synthetic.main.fragment_science.*

/**
 * A simple [Fragment] subclass.
 */
class EngineeringFragment : Fragment(), BooksAdapter.onClick {
    lateinit var data: MutableList<Categories>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_engineering, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        data = mutableListOf<Categories>()
        data.add(
            Categories(
                1,
                "Electrical Engineering 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.electrical_engineering_book
            )
        )
        data.add(
            Categories(
                2,
                "Architect Engineering nd2 Edition",
                getString(R.string.category_datails),
                R.drawable.architecture_engineering_book
            )
        )
        data.add(
            Categories(
                3,
                "Civil Engineering 4th Edition",
                getString(R.string.category_datails),
                R.drawable.civil_engineering_book
            )
        )
        data.add(
            Categories(
                4,
                "Information Security Engineering 1st Edition",
                getString(R.string.category_datails),
                R.drawable.cyber_security_book
            )
        )
        data.add(
            Categories(
                5,
                "Technical Engineering 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.mechanical_engineering_book
            )
        )
        data.add(
            Categories(
                6,
                "Computer Engineering 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.web_development
            )
        )
        data.add(
            Categories(
                7,
                "Mechanic Engineering 4th Edition",
                getString(R.string.category_datails),
                R.drawable.industrial_book
            )
        )
        data.add(
            Categories(
                8,
                "How to program 4th Edition",
                getString(R.string.category_datails),
                R.drawable.tech_image3
            )
        )
        data.add(
            Categories(
                9,
                "C++ Language 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.it_pic1
            )
        )
        data.add(
            Categories(
                10,
                "Computer Science 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.programming_languages
            )
        )
        data.add(
            Categories(
                11,
                "W3WEB 1st Edition",
                getString(R.string.category_datails),
                R.drawable.iot_security
            )
        )
        data.add(
            Categories(
                12,
                "Technical Terminology 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.data_sciense
            )
        )
        data.add(
            Categories(
                13,
                "W3Schools 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.it6
            )
        )

        rvEngineering.layoutManager = LinearLayoutManager(context)
        rvEngineering.setHasFixedSize(true)
        val EngineeringAdapter = CategoriesAdapter(context!!, data, this)
        rvEngineering.adapter = EngineeringAdapter
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
