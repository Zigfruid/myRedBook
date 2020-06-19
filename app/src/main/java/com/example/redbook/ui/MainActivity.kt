package com.example.redbook.ui

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.redbook.R
import com.example.redbook.data.model.Animal
import com.example.redbook.fragment.AnimalFragment
import com.example.redbook.fragment.FavoriteAnimal
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    companion object {
        const val TYPE_ID = "typeId"
        const val INVERTEBRATES = 1
        const val FISHES = 2
        const val REPTILES = 3
        const val BIRDS = 4
        const val MAMMALS = 5
        const val FAVORITE = 5
    }
    private var models: List<Animal> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        val fragment = AnimalFragment()
        val bundle = Bundle()
        bundle.putInt(TYPE_ID, INVERTEBRATES)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()

        navView.setNavigationItemSelectedListener {
            val mFragment = AnimalFragment()
            val mBundle = Bundle()
            val fFragment = FavoriteAnimal()
            val fBundle = Bundle()


            when(it.itemId){

                R.id.nav_invertebrates -> {
                    mBundle.putInt(TYPE_ID, INVERTEBRATES)
                    mFragment.arguments = mBundle
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, mFragment).commit()

                }

                R.id.nav_fishes -> {
                    mBundle.putInt(TYPE_ID, FISHES)
                    mFragment.arguments = mBundle
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, mFragment).commit()

                }
                R.id.nav_reptiles -> {
                    mBundle.putInt(TYPE_ID, REPTILES)
                    mFragment.arguments = mBundle
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, mFragment).commit()
                }
                R.id.nav_birds -> {
                    mBundle.putInt(TYPE_ID, BIRDS)
                    mFragment.arguments = mBundle
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, mFragment).commit()
                }
                R.id.nav_mammals -> {
                    mBundle.putInt(TYPE_ID, MAMMALS)
                    mFragment.arguments = mBundle
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, mFragment).commit()
                }

                R.id.nav_favorite -> {
                    fFragment.arguments = fBundle
                    fBundle.putInt(TYPE_ID, FISHES)
                    fFragment.arguments = fBundle
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fFragment).commit()

                }
                
                else -> return@setNavigationItemSelectedListener false

            }
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

}
