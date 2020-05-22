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
import kotlinx.android.synthetic.main.fragment_science.*
import kotlinx.android.synthetic.main.fragment_wildlife.*

/**
 * A simple [Fragment] subclass.
 */
class WildlifeFragment : Fragment(), BooksAdapter.onClick {
    lateinit var data: MutableList<Categories>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_wildlife, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        data = mutableListOf<Categories>()
        data.add(
            Categories(
                1,
                "The king of kings",
                getString(R.string.category_datails),
                R.drawable.wildlife5
            )
        )
        data.add(
            Categories(
                2,
                "Lions & Tigers nd2 Edition",
                getString(R.string.category_datails),
                R.drawable.wildlife2
            )
        )
        data.add(
            Categories(
                3,
                "Game of Thrones 4th Edition",
                getString(R.string.category_datails),
                R.drawable.wildlife1
            )
        )
        data.add(
            Categories(
                4,
                "Wildlife Terminology 1st Edition",
                getString(R.string.category_datails),
                R.drawable.wildlife8
            )
        )
        data.add(
            Categories(
                5,
                "Treatment 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.wildlife10
            )
        )
        data.add(
            Categories(
                6,
                "Animals 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.wildlife9
            )
        )
        data.add(
            Categories(
                7,
                "The Pets 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.wildlife7
            )
        )
        data.add(
            Categories(
                8,
                "Predators Animals 4th Edition",
                getString(R.string.category_datails),
                R.drawable.wildlife6
            )
        )
        data.add(
            Categories(
                9,
                "The Expindeples 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.wildlife4
            )
        )
        data.add(
            Categories(
                10,
                "Teh Consumers 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.wildlife3
            )
        )
        data.add(
            Categories(
                11,
                "Behind the scene limit Edition",
                getString(R.string.category_datails),
                R.drawable.wildlife11
            )
        )
        data.add(
            Categories(
                12,
                "How to live 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.wildlife8
            )
        )
        data.add(
            Categories(
                13,
                "The king of Jungle 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.wildlife_book
            )
        )
        data.add(
            Categories(
                14,
                "Bee 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.bee_logo
            )
        )
        data.add(
            Categories(
                15,
                "Stuff 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.bestof
            )
        )
        data.add(
            Categories(
                16,
                "Junanji 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.evil
            )
        )
        data.add(
            Categories(
                17,
                "Some of Command 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.wallpapers2
            )
        )

        rvWildlife.layoutManager = LinearLayoutManager(context)
        rvWildlife.setHasFixedSize(true)
        val WildlifeAdapter = CategoriesAdapter(context!!, data, this)
        rvWildlife.adapter = WildlifeAdapter
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
