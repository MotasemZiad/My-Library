package com.motasem.ziad.mylibrary.fragment


import AddBook
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.motasem.ziad.mylibrary.DetailsActivity
import com.motasem.ziad.mylibrary.R
import com.motasem.ziad.mylibrary.adapter.BooksAdapter
import com.motasem.ziad.mylibrary.adapter.CategoriesAdapter
import com.motasem.ziad.mylibrary.db.DatabaseHelper
import com.motasem.ziad.mylibrary.model.Categories
import kotlinx.android.synthetic.main.fragment_science.*

/**
 * A simple [Fragment] subclass.
 */
class ScienceFragment : Fragment(), BooksAdapter.onClick {
    lateinit var data: MutableList<Categories>
    lateinit var db: DatabaseHelper
    var searchView: SearchView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_science, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        db = DatabaseHelper(activity!!)
        data = mutableListOf()
        data.add(
            Categories(
                1,
                "Physics 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.mathematics
            )
        )
        data.add(
            Categories(
                2,
                "Chemistry nd2 Edition",
                getString(R.string.category_datails),
                R.drawable.chemistry_book
            )
        )
        data.add(
            Categories(
                3,
                "Biology 4th Edition",
                getString(R.string.category_datails),
                R.drawable.biology
            )
        )
        data.add(
            Categories(
                4,
                "Milky way galaxy",
                getString(R.string.category_datails),
                R.drawable.milky_way_galaxy
            )
        )
        data.add(
            Categories(
                5,
                "behind the scene limit edition",
                getString(R.string.category_datails),
                R.drawable.milky_way_galaxy1
            )
        )
        data.add(
            Categories(
                6,
                "Getting Started",
                getString(R.string.category_datails),
                R.drawable.milky_way_galaxy2
            )
        )
        data.add(
            Categories(
                7,
                "The name of the Wind",
                getString(R.string.category_datails),
                R.drawable.black_hole
            )
        )
        data.add(
            Categories(
                8,
                "The black hole key",
                getString(R.string.category_datails),
                R.drawable.black_holee
            )
        )
        data.add(
            Categories(
                9,
                "A man can change the world",
                getString(R.string.category_datails),
                R.drawable.man
            )
        )
        data.add(
            Categories(
                10,
                "Book Title",
                getString(R.string.category_datails),
                R.drawable.science_books
            )
        )
        data.add(
            Categories(
                11,
                "Secret Language",
                getString(R.string.category_datails),
                R.drawable.ic_einstein
            )
        )
        data.add(
            Categories(
                12,
                "the name of the caves",
                getString(R.string.category_datails),
                R.drawable.ic_mars
            )
        )
        data.add(
            Categories(
                13,
                "Name Star",
                getString(R.string.category_datails),
                R.drawable.ic_virus
            )
        )
        data.add(
            Categories(
                14,
                "Name Star",
                getString(R.string.category_datails),
                R.drawable.ic_molecule
            )
        )
        data.add(
            Categories(
                15,
                "Name Star",
                getString(R.string.category_datails),
                R.drawable.ic_plasma_ball
            )
        )


        rvScience.layoutManager = LinearLayoutManager(context)
        rvScience.setHasFixedSize(true)
        val ScienceAdapter = CategoriesAdapter(context!!, data, this)
        rvScience.adapter = ScienceAdapter

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
