package com.motasem.ziad.mylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.motasem.ziad.mylibrary.fragment.LoginFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager.beginTransaction().replace(R.id.LoginContainer, LoginFragment()).commit()
    }
}
