package com.motasem.ziad.mylibrary

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.motasem.ziad.mylibrary.adapter.BooksAdapter
import com.motasem.ziad.mylibrary.adapter.CategoriesAdapter
import com.motasem.ziad.mylibrary.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var searchView: SearchView
    lateinit var adapter: CategoriesAdapter
    lateinit var adapter1: BooksAdapter
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.borrowed -> {
                    replaceFragment(BorrowedFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.favorate -> {
                    replaceFragment(FavorateFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        nav_view.selectedItemId = R.id.home


    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.mainContainer,
            fragment
        ).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        var item: MenuItem = menu!!.findItem(R.id.search)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.filter.filter(query)
                adapter1.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                adapter1.filter.filter(newText)
                return false
            }

        })


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> {
                return true
            }
            R.id.share -> {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Motasem Z. AbuNema")
                sendIntent.type = "text/plain"
                startActivity(sendIntent)
            }
            R.id.contact_us -> {
                val emailIntent =
                    Intent(
                        Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto", "my20library@gmail.com", null)
                    )

                startActivity(Intent.createChooser(emailIntent, "Send email..."))
            }
            R.id.rate_us -> {
                Toast.makeText(this, "Rate us", Toast.LENGTH_SHORT).show()
            }
            R.id.setting -> {
                val goToSettingActivity = Intent(this, SettingActivity::class.java)
                startActivity(goToSettingActivity)
            }
            R.id.about -> {
                val goToAboutActivity = Intent(this, AboutActivity::class.java)
                startActivity(goToAboutActivity)
            }
            R.id.log_out -> {
                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setMessage("Are you sure you want to Logout?")
                alertDialog.setCancelable(false)
                alertDialog.setIcon(R.drawable.ic_exit_to_app_black_24dp)

                alertDialog.setPositiveButton("Yes") { _, _ ->
                    val sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.clear().apply()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                alertDialog.setNegativeButton("No") { _, _ ->
                }
                alertDialog.create().show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (!searchView.isIconified) {
            searchView.isIconified = true
            return
        }
        super.onBackPressed()
    }
}

