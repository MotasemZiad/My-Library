package com.motasem.ziad.mylibrary.fragment


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.motasem.ziad.mylibrary.LoginActivity
import com.motasem.ziad.mylibrary.MainActivity

import com.motasem.ziad.mylibrary.R
import com.motasem.ziad.mylibrary.db.DatabaseHelper
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    lateinit var db: DatabaseHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        db = DatabaseHelper(activity!!)
        val b = arguments

        if (b != null) {
            edUsername.setText(b.getString("username"))
            edPassword.setText(b.getString("password"))
        }
        val sharedPref = activity!!.getSharedPreferences("MyPref", Activity.MODE_PRIVATE)
        if (sharedPref.getBoolean("isLogin", false)) {
            val i = Intent(activity, MainActivity::class.java)
            startActivity(i)
        }
        btnLogin.setOnClickListener {
            if (edUsername.text.isEmpty())
                edUsername.error = "Fill this field"
            if (edPassword.text.isEmpty())
                edPassword.error = "Fill this field"
            if (edUsername.text.isNotEmpty() && edPassword.text.isNotEmpty()) {
                val editor = sharedPref.edit()
                editor.putString("name", edUsername.text.toString())
                editor.putBoolean("isLogin", true)
                editor.apply()
                val i = Intent(activity, MainActivity::class.java)
                startActivity(i)
                activity!!.finish()
            }
            if (!nameValidation(edUsername.text.toString())) {
                edUsername.error = "Incorrect name"
            }
        }
        tvNotMemberYet.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.LoginContainer, SignupFragment()).addToBackStack(null).commit()
        }
        super.onActivityCreated(savedInstanceState)
    }

    fun nameValidation(name: String): Boolean {
        var upperc = false
        var lowerc = false
        var white = false
        for (i in 0 until name.length - 1) {
            if (Character.isUpperCase(name[i])) {
                upperc = true
                break
            }
        }
        for (i in 0 until name.length - 1) {
            if (Character.isLowerCase(name[i])) {
                lowerc = true
                break
            }
        }
        for (i in 0 until name.length - 1) {
            if (Character.isWhitespace(name[i])) {
                white = true
                break
            }
        }

        if (upperc && lowerc && white) {
            return true
        }
        return false
    }

}
