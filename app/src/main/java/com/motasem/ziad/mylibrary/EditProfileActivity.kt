package com.motasem.ziad.mylibrary

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.motasem.ziad.mylibrary.fragment.ProfileFragment
import com.vansuita.pickimage.bean.PickResult
import com.vansuita.pickimage.bundle.PickSetup
import com.vansuita.pickimage.dialog.PickImageDialog
import com.vansuita.pickimage.listeners.IPickResult
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity(), IPickResult {
    var s: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val userId = intent.getIntExtra("id", -1)
        edUsername.setText(intent.getStringExtra("name"))
        edJob.setText(intent.getStringExtra("job"))
        edEmail.setText(intent.getStringExtra("email"))
        edAge.setText(intent.getStringExtra("age"))
        edPhone.setText(intent.getStringExtra("phone"))
        edFrom.setText(intent.getStringExtra("from"))
        edLives.setText(intent.getStringExtra("lives"))
        edRelation.setText(intent.getStringExtra("relation"))

        imgUser.setOnClickListener {
            PickImageDialog.build(PickSetup()).show(this)
        }
        btnImg.setOnClickListener {
            PickImageDialog.build(PickSetup()).show(this)
        }



        btnSave.setOnClickListener {
            if (edUsername.text.isNotEmpty() && edEmail.text.isNotEmpty() && edAge.text.isNotEmpty() && edPhone.text.isNotEmpty() && edFrom.text.isNotEmpty() && edLives.text.isNotEmpty() && edRelation.text.isNotEmpty()) {
                val b = Bundle()
                b.putInt("id", 1)
                b.putString("username", edUsername.text.toString())
                b.putString("job", edJob.text.toString())
                b.putString("email", edEmail.text.toString())
                b.putString("age", edAge.text.toString())
                b.putString("phone", edPhone.text.toString())
                b.putString("from", edFrom.text.toString())
                b.putString("lives", edLives.text.toString())
                b.putString("relation", edRelation.text.toString())
                val fragment = ProfileFragment()
                fragment.arguments = b
                supportFragmentManager.beginTransaction().add(R.id.mainContainer, fragment)
                    .commit()
            } else {
                Toast.makeText(this, "All fields above are required !", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onPickResult(r: PickResult?) {
        if (r!!.error == null) {
            s = r.uri.toString()
            imgUser.setImageURI(r.uri)
        } else {
            Toast.makeText(this, r.error.message, Toast.LENGTH_LONG).show()
        }
    }


}
