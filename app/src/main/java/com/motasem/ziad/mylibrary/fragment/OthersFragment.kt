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
import kotlinx.android.synthetic.main.fragment_security.*

/**
 * A simple [Fragment] subclass.
 */
class OthersFragment : Fragment(), BooksAdapter.onClick {
    lateinit var data: MutableList<Categories>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_security, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        data = mutableListOf<Categories>()
        data.add(
            Categories(
                1,
                "BlockChain 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.it_pic3
            )
        )
        data.add(
            Categories(
                2,
                "Siprany Information Security nd2 Edition",
                getString(R.string.category_datails),
                R.drawable.ai_book
            )
        )
        data.add(
            Categories(
                3,
                "Hacking 4th Edition",
                getString(R.string.category_datails),
                R.drawable.ai4
            )
        )
        data.add(
            Categories(
                4,
                "Some of Instructions 1st Edition",
                getString(R.string.category_datails),
                R.drawable.ai3
            )
        )
        data.add(
            Categories(
                5,
                "CIH 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.ai2
            )
        )
        data.add(
            Categories(
                6,
                "hack with python 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.ai1
            )
        )
        data.add(
            Categories(
                7,
                "Artificial Intelligence 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.cybersecurity_for_the_enterprise
            )
        )
        data.add(
            Categories(
                8,
                "Data Science 4th Edition",
                getString(R.string.category_datails),
                R.drawable.cyber_security5
            )
        )
        data.add(
            Categories(
                9,
                "Artificial Intelligence 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.cyber_security3
            )
        )
        data.add(
            Categories(
                10,
                "Inturruption 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.cybersecurity2
            )
        )
        data.add(
            Categories(
                11,
                "MR. ROBOT 1st Edition",
                getString(R.string.category_datails),
                R.drawable.cyber_security
            )
        )
        data.add(
            Categories(
                12,
                "Iron man 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.cyber_security_book
            )
        )
        data.add(
            Categories(
                13,
                "Championship 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.data_analytics3
            )
        )
        data.add(
            Categories(
                14,
                "Championship 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.data_sciense
            )
        )
        data.add(
            Categories(
                15,
                "Championship 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.it_pic2
            )
        )
        data.add(
            Categories(
                16,
                "Championship 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.it_pic1
            )
        )
        data.add(
            Categories(
                17,
                "Championship 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.it6
            )
        )

        rvSecurity.layoutManager = LinearLayoutManager(context)
        rvSecurity.setHasFixedSize(true)
        val SecurityAdapter = CategoriesAdapter(context!!, data, this)
        rvSecurity.adapter = SecurityAdapter
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
