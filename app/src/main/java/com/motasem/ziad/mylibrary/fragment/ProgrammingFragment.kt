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
import kotlinx.android.synthetic.main.fragment_programming.*
import kotlinx.android.synthetic.main.fragment_science.*

/**
 * A simple [Fragment] subclass.
 */
class ProgrammingFragment : Fragment(), BooksAdapter.onClick {
    lateinit var data: MutableList<Categories>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_programming, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        data = mutableListOf<Categories>()
        data.add(
            Categories(
                1,
                "Java 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_java
            )
        )
        data.add(
            Categories(
                2,
                "Python nd2 Edition",
                getString(R.string.category_datails),
                R.drawable.ic_python
            )
        )
        data.add(
            Categories(
                3,
                "JavaScript 4th Edition",
                getString(R.string.category_datails),
                R.drawable.ic_java_script
            )
        )
        data.add(
            Categories(
                4,
                "C++ 1st Edition",
                getString(R.string.category_datails),
                R.drawable.pl1
            )
        )
        data.add(
            Categories(
                5,
                "PHP 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.iotecosystem
            )
        )
        data.add(
            Categories(
                6,
                "PERL 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.apple3
            )
        )
        data.add(
            Categories(
                7,
                "C 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.programming_book
            )
        )
        data.add(
            Categories(
                8,
                "Swift 4th Edition",
                getString(R.string.category_datails),
                R.drawable.ic_swift
            )
        )
        data.add(
            Categories(
                9,
                "Kotlin 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.kotlin_bg
            )
        )
        data.add(
            Categories(
                10,
                "PHP Laravel 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.tech_image
            )
        )
        data.add(
            Categories(
                11,
                "ASP.NET 1st Edition",
                getString(R.string.category_datails),
                R.drawable.tech_image2
            )
        )
        data.add(
            Categories(
                12,
                "Ruby 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_ruby
            )
        )
        data.add(
            Categories(
                13,
                "AI 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.ai1
            )
        )
        data.add(
            Categories(
                14,
                "the girl without a name 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.tech_image3
            )
        )
        data.add(
            Categories(
                15,
                "my name is great 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.tech_image5
            )
        )
        data.add(
            Categories(
                16,
                "behind the scene 1st Edition",
                getString(R.string.category_datails),
                R.drawable.it6
            )
        )
        data.add(
            Categories(
                17,
                "Dark web 4th Edition",
                getString(R.string.category_datails),
                R.drawable.it_pic1
            )
        )
        data.add(
            Categories(
                18,
                "AI 4th Edition",
                getString(R.string.category_datails),
                R.drawable.ai2
            )
        )
        data.add(
            Categories(
                19,
                "AI 6th Edition",
                getString(R.string.category_datails),
                R.drawable.ai_book
            )
        )
        data.add(
            Categories(
                20,
                "Mysql 6th Edition",
                getString(R.string.category_datails),
                R.drawable.ic_mysql
            )
        )
        data.add(
            Categories(
                21,
                "Android 8th Edition",
                getString(R.string.category_datails),
                R.drawable.android
            )
        )
        data.add(
            Categories(
                22,
                "Web development 4th Edition",
                getString(R.string.category_datails),
                R.drawable.web_development
            )
        )
        data.add(
            Categories(
                23,
                "IOT 9th Edition",
                getString(R.string.category_datails),
                R.drawable.internet_of_things
            )
        )

        rvProgramming.layoutManager = LinearLayoutManager(context)
        rvProgramming.setHasFixedSize(true)
        val ProgrammingAdapter = CategoriesAdapter(context!!, data, this)
        rvProgramming.adapter = ProgrammingAdapter
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
