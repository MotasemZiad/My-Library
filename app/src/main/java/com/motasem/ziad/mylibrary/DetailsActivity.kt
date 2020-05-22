package com.motasem.ziad.mylibrary

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.motasem.ziad.mylibrary.db.DatabaseHelper
import com.motasem.ziad.mylibrary.model.Categories
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)
        var data: MutableList<Categories>
        val db = DatabaseHelper(this)
        var isFavorate: Boolean = false
        val id = intent.getIntExtra("id", -1)
        val name = intent.getStringExtra("name")
        val details = intent.getStringExtra("details")
        val img = intent.getIntExtra("img", -1)
        toolbar_layout.title = name
        toolbar_layout.setBackgroundResource(img)

        fabFavorate.setOnClickListener {
            if (db.insertCategories(
                    name,
                    details,
                    img
                ) && !isFavorate
            ) {
                Toast.makeText(this, "Added to favorate", Toast.LENGTH_SHORT).show()
                fabFavorate.setImageResource(R.drawable.ic_favorite_red_24dp)
                isFavorate = true
            } else {
                Toast.makeText(this, "removed from favorate", Toast.LENGTH_SHORT).show()
                fabFavorate.setImageResource(R.drawable.ic_favorite_black_24dp)
                isFavorate = false
            }
        }

        fabBorrow.setOnClickListener {
            if (db.insertCategories(name, details, img)) {
                Toast.makeText(this, "you’ve just borrow this book", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
