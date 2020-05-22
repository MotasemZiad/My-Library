package com.motasem.ziad.mylibrary.fragment


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.motasem.ziad.mylibrary.EditProfileActivity
import com.motasem.ziad.mylibrary.R
import kotlinx.android.synthetic.main.fragment_profile.*


/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        val sharedPref = activity!!.getSharedPreferences("MyPref", Activity.MODE_PRIVATE)
        tvName?.text = sharedPref.getString("name", "Empty")
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        val b = arguments
        if (b != null) {
            // val userId = b.getInt("id", -1)
            tvName.text = b.getString("username")
            tvJob.text = b.getString("job")
            edEmail.text = b.getString("email")
            edAge.text = b.getString("age")
            edPhone.text = b.getString("phone")
            edFrom.text = b.getString("from")
            edLives.text = b.getString("lives")
            edRelation.text = b.getString("relation")
        }
        fabEdit.setOnClickListener {
            val i = Intent(activity, EditProfileActivity::class.java)
            i.putExtra("id", 1)
            i.putExtra("name", tvName.text.toString())
            i.putExtra("job", tvJob.text.toString())
            i.putExtra("email", edEmail.text.toString())
            i.putExtra("age", edAge.text.toString())
            i.putExtra("phone", edPhone.text.toString())
            i.putExtra("from", edFrom.text.toString())
            i.putExtra("lives", edLives.text.toString())
            i.putExtra("relation", edRelation.text.toString())
            startActivity(i)
        }
        super.onActivityCreated(savedInstanceState)
    }


}
