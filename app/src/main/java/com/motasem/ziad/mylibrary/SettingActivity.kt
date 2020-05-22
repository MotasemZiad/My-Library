package com.motasem.ziad.mylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.actionbar_setting.*

import kotlinx.android.synthetic.main.content_setting.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actionbar_setting)

        setSupportActionBar(toolbar)

        btnGeneral.setOnClickListener { view ->
            Snackbar.make(view, "you pressed General", Snackbar.LENGTH_SHORT).show()
        }
        btnNotification.setOnClickListener { view ->
            Snackbar.make(view, "you pressed Notification", Snackbar.LENGTH_SHORT).show()
        }
        btnPrivacy.setOnClickListener { view ->
            Snackbar.make(view, "you pressed Privacy and Politics", Snackbar.LENGTH_SHORT).show()
        }
        btnUserAgreement.setOnClickListener { view ->
            Snackbar.make(view, "you pressed User Agreement", Snackbar.LENGTH_SHORT).show()
        }
        btnLanguages.setOnClickListener { view ->
            Snackbar.make(view, "you pressed Language", Snackbar.LENGTH_SHORT).show()
        }
        btnFAQ.setOnClickListener { view ->
            Snackbar.make(view, "you pressed FAQ", Snackbar.LENGTH_SHORT).show()
        }
        btnTerms.setOnClickListener { view ->
            Snackbar.make(view, "you pressed Terms and Conditions", Snackbar.LENGTH_SHORT).show()
        }

    }
}
