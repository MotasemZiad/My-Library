package com.motasem.ziad.mylibrary.fragment


import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.motasem.ziad.mylibrary.R
import com.motasem.ziad.mylibrary.db.DatabaseHelper
import kotlinx.android.synthetic.main.fragment_signup.*
import kotlinx.android.synthetic.main.fragment_signup.view.*

/**
 * A simple [Fragment] subclass.
 */
class SignupFragment : Fragment() {
    lateinit var db: DatabaseHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_signup, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        db = DatabaseHelper(activity!!)
        btnSignup.setOnClickListener {
            if (edUsername.text.isEmpty()) {
                edUsername.error = "Fill this field"
            }
            if (edEmail.text.isEmpty()) {
                edEmail.error = "Fill this field"
            }
            if (edPhone.text.isEmpty()) {
                edPhone.error = "Fill this field"
            }
            if (edPassword.text.isEmpty()) {
                edPassword.error = "Fill this field"
            }
            if (edConfirmPassword.text.isEmpty()) {
                edConfirmPassword.error = "Fill this field"
            }
            if (edUsername.text.isEmpty()) {
                edUsername.error = "Fill this field"
            }
            if (edUsername.text.isNotEmpty() && edEmail.text.isNotEmpty() && edPhone.text.isNotEmpty() && edPassword.text.isNotEmpty() && edConfirmPassword.text.isNotEmpty() && (edPassword.text.toString() == edConfirmPassword.text.toString())) {

                if (!Patterns.EMAIL_ADDRESS.matcher(edEmail.text.toString()).matches()) {
                    edEmail.error = "Incorrect Email"
                }
                if (!passValidation(edPassword.text.toString())) {
                    edPassword.error = "Weak Password"
                }
                if (!nameValidation(edUsername.text.toString())) {
                    edUsername.error = "Please Enter a Really Name"
                }
                if (Patterns.EMAIL_ADDRESS.matcher(edEmail.text.toString()).matches() && passValidation(
                        edPassword.text.toString()
                    ) && nameValidation(edUsername.text.toString())
                ) {
                    val b = Bundle()
                    b.putString("username", edUsername.text.toString())
                    b.putString("password", edPassword.text.toString())
                    val fragment = LoginFragment()
                    fragment.arguments = b
                    activity!!.supportFragmentManager.beginTransaction()
                        .replace(R.id.LoginContainer, fragment).commit()
                    if (db.insertUser(
                            edUsername.text.toString(),
                            edEmail.text.toString(),
                            edPassword.text.toString(),
                            edPhone.text.toString()
                        )
                    ) {
                        Toast.makeText(
                            activity,
                            "You’ve already created a new account",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        Toast.makeText(activity, "Error", Toast.LENGTH_SHORT)
                            .show()
                    }
                }


            } else {
                Toast.makeText(
                    activity,
                    "Two Passwords doesn’t match each other",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }
        tvAlreadyHaveAccount.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.LoginContainer, LoginFragment()).addToBackStack(null).commit()
        }
        super.onActivityCreated(savedInstanceState)
    }

    fun passValidation(password: String): Boolean {
        var upperc = false
        var lowerc = false
        var digetc = false
        var schar = false
        if (password.length >= 6) {
            for (i in 0 until password.length - 1) {
                if (Character.isUpperCase(password[i])) {
                    upperc = true
                    break
                }
            }
            for (i in 0 until password.length - 1) {
                if (Character.isLowerCase(password[i])) {
                    lowerc = true
                    break
                }
            }
            for (i in 0 until password.length - 1) {
                if (Character.isDigit(password[i])) {
                    digetc = true
                    break
                }
            }
            for (i in 0 until password.length - 1) {

                when (password[i]) {
                    '@' -> schar = true
                    '#' -> schar = true
                    '$' -> schar = true
                    '%' -> schar = true
                    '&' -> schar = true
                }
                if (schar) {
                    break
                }
            }
        }

        if (upperc && lowerc && digetc && schar) {
            return true
        }
        return false
    }

    ///////////
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
