package com.motasem.ziad.mylibrary.fragment


import AddBook
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.motasem.ziad.mylibrary.DetailsActivity
import com.motasem.ziad.mylibrary.R
import com.motasem.ziad.mylibrary.adapter.AddBookAdapter
import com.motasem.ziad.mylibrary.adapter.BooksAdapter
import com.motasem.ziad.mylibrary.adapter.CategoriesAdapter
import com.motasem.ziad.mylibrary.db.DatabaseHelper
import com.motasem.ziad.mylibrary.model.Categories
import kotlinx.android.synthetic.main.fragment_bio.*
import kotlinx.android.synthetic.main.fragment_chess.*

/**
 * A simple [Fragment] subclass.
 */
class ChessFragment : Fragment(), BooksAdapter.onClick {
    lateinit var data: MutableList<Categories>
    lateinit var db: DatabaseHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_chess, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        db = DatabaseHelper(activity!!)
        data = mutableListOf()
        // data1 = mutableListOf<AddBook>()
        data.add(
            Categories(
                1,
                "Alfa Zero 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.ai2
            )
        )
        data.add(
            Categories(
                2,
                "Game of Engines nd2 Edition",
                getString(R.string.category_datails),
                R.drawable.alpha_stock1
            )
        )
        data.add(
            Categories(
                3,
                "How to think like Magnus Carlesn",
                getString(R.string.category_datails),
                R.drawable.carlesn
            )
        )
        data.add(
            Categories(
                4,
                "Anand limit Edition",
                getString(R.string.category_datails),
                R.drawable.anand
            )
        )
        data.add(
            Categories(
                5,
                "Shogi 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.shogi
            )
        )
        data.add(
            Categories(
                6,
                "Play chess 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.alpha_stock
            )
        )
        data.add(
            Categories(
                7,
                "Have fun 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.alpha2
            )
        )
        data.add(
            Categories(
                8,
                "Win or Win 4th Edition",
                getString(R.string.category_datails),
                R.drawable.chess2
            )
        )
        data.add(
            Categories(
                9,
                "Draw games 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.chess1
            )
        )
        data.add(
            Categories(
                10,
                "AI 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.alpha_stock1
            )
        )
        data.add(
            Categories(
                11,
                "Instructions 1st Edition",
                getString(R.string.category_datails),
                R.drawable.alphazero2
            )
        )
        data.add(
            Categories(
                12,
                "AI 3rd Edition",
                getString(R.string.category_datails),
                R.drawable.alpha_zero12
            )
        )
        data.add(
            Categories(
                15,
                "Love Chess Edition",
                getString(R.string.category_datails),
                R.drawable.chess_book
            )
        )
        data.add(
            Categories(
                13,
                "Fabio Caruana 2nd Edition",
                getString(R.string.category_datails),
                R.drawable.carlsen_caruana
            )
        )
        data.add(
            Categories(
                14,
                "Alpha zero Vs. Stock fish ",
                getString(R.string.category_datails),
                R.drawable.alpha_stockfish
            )
        )

        rvChess.layoutManager = LinearLayoutManager(context)
        rvChess.setHasFixedSize(true)
        val chessAdapter = CategoriesAdapter(context!!, data, this)
        rvChess.adapter = chessAdapter
        /*  val BioAdapter1 = AddBookAdapter(context!!, data1, this)
          rvBio.adapter = BioAdapter1 */
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
