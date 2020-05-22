package com.motasem.ziad.mylibrary

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.motasem.ziad.mylibrary.db.DatabaseHelper
import com.vansuita.pickimage.bean.PickResult
import com.vansuita.pickimage.bundle.PickSetup
import com.vansuita.pickimage.dialog.PickImageDialog
import com.vansuita.pickimage.listeners.IPickResult
import kotlinx.android.synthetic.main.activity_add_book.*

class AddBookActivity : AppCompatActivity(), IPickResult {
    var s: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        val db = DatabaseHelper(this)

        imgBook.setOnClickListener {
            PickImageDialog.build(PickSetup()).show(this)
        }
        btnBookImg.setOnClickListener {
            PickImageDialog.build(PickSetup()).show(this)
        }

        btnAddBook.setOnClickListener {
            if (edUsername.text.isNotEmpty() && edEmail.text.isNotEmpty() && edTitle.text.isNotEmpty() && edSummary.text.isNotEmpty()) {
                // supportFragmentManager.beginTransaction() .replace(R.id.mainContainer, HomeFragment()).commit()
                if (db.insertAddBook(
                        edTitle.text.toString(),
                        edSummary.text.toString(),
                        s
                    )
                ) {
                    Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show()
                    edUsername.text.clear()
                    edEmail.text.clear()
                    edTitle.text.clear()
                    edSummary.text.clear()
                } else {
                    Toast.makeText(this, "Add Failed", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "All fields above are required !", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onPickResult(r: PickResult?) {
        if (r!!.error == null) {
            s = r.uri.toString()
            imgBook.setImageURI(r.uri)
        } else {
            Toast.makeText(this, r.error.message, Toast.LENGTH_LONG).show()
        }
    }

}
