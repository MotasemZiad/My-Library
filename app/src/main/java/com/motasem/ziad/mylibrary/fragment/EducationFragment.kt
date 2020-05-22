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
import kotlinx.android.synthetic.main.fragment_education.*
import kotlinx.android.synthetic.main.fragment_science.*

/**
 * A simple [Fragment] subclass.
 */
class EducationFragment : Fragment(), BooksAdapter.onClick {
    lateinit var data: MutableList<Categories>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_education, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        data = mutableListOf<Categories>()
        data.add(
            Categories(
                1,
                "Math 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.mathematics
            )
        )
        data.add(
            Categories(
                2,
                "Rilegion nd2 Edition",
                getString(R.string.category_datails),
                R.drawable.ic_quran
            )
        )
        data.add(
            Categories(
                3,
                "Alpert Einstein 4th Edition",
                getString(R.string.category_datails),
                R.drawable.ic_einstein
            )
        )
        data.add(
            Categories(
                4,
                "Study less study smart 1st Edition",
                getString(R.string.category_datails),
                R.drawable.ic_abacus
            )
        )
        data.add(
            Categories(
                5,
                "How to calc 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_books
            )
        )
        data.add(
            Categories(
                6,
                "Discrete Mathematics 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_open_book
            )
        )
        data.add(
            Categories(
                7,
                "Zero point 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.education_book
            )
        )
        data.add(
            Categories(
                8,
                "Biochemistry 4th Edition",
                getString(R.string.category_datails),
                R.drawable.ic_biochemist
            )
        )
        data.add(
            Categories(
                9,
                "How to think 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_classroom
            )
        )
        data.add(
            Categories(
                10,
                "Mathematics for computer graphics",
                getString(R.string.category_datails),
                R.drawable.math_book
            )
        )
        data.add(
            Categories(
                11,
                "Biology 1st Edition",
                getString(R.string.category_datails),
                R.drawable.biology
            )
        )
        data.add(
            Categories(
                12,
                "Chemistry 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.chemistry_book
            )
        )
        data.add(
            Categories(
                13,
                "Physics nd2 Edition",
                getString(R.string.category_datails),
                R.drawable.physics_book
            )
        )

        rvEducation.layoutManager = LinearLayoutManager(context)
        rvEducation.setHasFixedSize(true)
        val EducationAdapter = CategoriesAdapter(context!!, data, this)
        rvEducation.adapter = EducationAdapter
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
