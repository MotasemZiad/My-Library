package com.motasem.ziad.mylibrary.fragment


import AddBook
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
import com.motasem.ziad.mylibrary.adapter.AddBookAdapter
import com.motasem.ziad.mylibrary.adapter.BooksAdapter
import com.motasem.ziad.mylibrary.adapter.CategoriesAdapter
import com.motasem.ziad.mylibrary.db.DatabaseHelper
import com.motasem.ziad.mylibrary.model.Categories
import kotlinx.android.synthetic.main.fragment_bio.*
import kotlinx.android.synthetic.main.fragment_science.*

/**
 * A simple [Fragment] subclass.
 */
class BioFragment : Fragment(), BooksAdapter.onClick {
    lateinit var data: MutableList<Categories>
    lateinit var data1: MutableList<AddBook>
    lateinit var db:DatabaseHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_bio, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        db = DatabaseHelper(activity!!)
        data = mutableListOf<Categories>()
      //  data1 = mutableListOf<AddBook>()
        data.add(
            Categories(
                1,
                "Jacky Chan ",
                getString(R.string.category_datails),
                R.drawable.shan_bio
            )
        )
        data.add(
            Categories(
                2,
                "Steave Jobs nd2 Edition",
                getString(R.string.category_datails),
                R.drawable.jobs_bio
            )
        )
        data.add(
            Categories(
                3,
                "James Bond 4th Edition",
                getString(R.string.category_datails),
                R.drawable.james_bio
            )
        )
        data.add(
            Categories(
                4,
                "On the way 1st Edition",
                getString(R.string.category_datails),
                R.drawable.ic_biography2
            )
        )
        data.add(
            Categories(
                5,
                "Who is the following? 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_biography1
            )
        )
        data.add(
            Categories(
                6,
                "Gabpriel Barbosa 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.ic_biography
            )
        )
        data.add(
            Categories(
                7,
                " Dirilis Ertugrul ",
                getString(R.string.category_datails),
                R.drawable.ertugrul
            )
        )
        data.add(
            Categories(
                8,
                "Curulus Osman ",
                getString(R.string.category_datails),
                R.drawable.kurulus_osman
            )
        )
        data.add(
            Categories(
                9,
                "Alp Arslan ",
                getString(R.string.category_datails),
                R.drawable.alp_arslan
            )
        )
        data.add(
            Categories(
                10,
                "Malik Sah 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.sira_book
            )
        )
        data.add(
            Categories(
                11,
                "The prophet Muhammed 1st Edition",
                getString(R.string.category_datails),
                R.drawable.prophet
            )
        )
        data.add(
            Categories(
                12,
                "Instructions 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.bio2
            )
        )
        data.add(
            Categories(
                13,
                "The Best  2nd Edition",
                getString(R.string.category_datails),
                R.drawable.bio1
            )
        )

      //  data1 = db.getAllAddBook()


        rvBio.layoutManager = LinearLayoutManager(context)
        rvBio.setHasFixedSize(true)
        val BioAdapter = CategoriesAdapter(context!!, data, this)
        rvBio.adapter = BioAdapter
       /* val BioAdapter1 = AddBookAdapter(context!!, data1, this)
        rvBio.adapter = BioAdapter1 */
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
