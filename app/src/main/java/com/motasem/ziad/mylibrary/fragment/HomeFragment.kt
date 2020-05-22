package com.motasem.ziad.mylibrary.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.motasem.ziad.mylibrary.AddBookActivity

import com.motasem.ziad.mylibrary.R
import com.motasem.ziad.mylibrary.adapter.BooksAdapter
import com.motasem.ziad.mylibrary.model.Books
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), BooksAdapter.onClick {

    lateinit var data: MutableList<Books>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {


        data = mutableListOf<Books>()
        data.add(Books(1, "Science", R.drawable.science_books))
        data.add(Books(2, "Programming", R.drawable.programming_book))
        data.add(Books(3, "Education", R.drawable.education_book))
        data.add(Books(4, "Engineering", R.drawable.electrical_engineering_book))
        data.add(Books(5, "Wildlife", R.drawable.wildlife_book))
        data.add(Books(6, "Chess", R.drawable.chess_book))
        data.add(Books(7, "Quran", R.drawable.ic_quran1))
        data.add(Books(8, "Biography", R.drawable.bio2))
        data.add(Books(9, "Languages", R.drawable.languages))
        data.add(Books(10, "Others", R.drawable.ic_open_book))

        rvBooks.layoutManager = GridLayoutManager(activity, 2)
        rvBooks.setHasFixedSize(true)
        val booksAdapter = BooksAdapter(activity!!, data, this)
        rvBooks.adapter = booksAdapter
        super.onActivityCreated(savedInstanceState)

        fabAddBook.setOnClickListener {
            val i = Intent(activity, AddBookActivity::class.java)
            startActivity(i)
        }

    }

    override fun onClickItem(position: Int) {
        when (data[position]) {
            data[0] -> {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, ScienceFragment()).addToBackStack(null).commit()
            }
            data[1] -> {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, ProgrammingFragment()).addToBackStack(null)
                    .commit()
            }
            data[2] -> {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, EducationFragment()).addToBackStack(null)
                    .commit()
            }
            data[3] -> {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, EngineeringFragment()).addToBackStack(null)
                    .commit()
            }
            data[4] -> {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, WildlifeFragment()).addToBackStack(null)
                    .commit()
            }
            data[5] -> {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, ChessFragment()).addToBackStack(null)
                    .commit()
            }
            data[6] -> {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, QuranFragment()).addToBackStack(null)
                    .commit()
            }
            data[7] -> {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, BioFragment()).addToBackStack(null)
                    .commit()
            }
            data[8] -> {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, LanguageFragment()).addToBackStack(null)
                    .commit()
            }
            data[9] -> {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, OthersFragment()).addToBackStack(null)
                    .commit()
            }


        }

    }



}
