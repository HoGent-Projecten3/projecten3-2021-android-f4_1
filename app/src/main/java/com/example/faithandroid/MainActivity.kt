package com.example.faithandroid

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.faithandroid.profiel.profielFragment
import com.google.android.material.navigation.NavigationView


//import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity(),DrawerInterface,NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout : DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_test)


        drawerLayout = findViewById(R.id.drawerLayout);
       // viewModel = ViewModelProvider(this).get(OverviewViewModel::class.java)



        //setSupportActionBar(R.id.)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.NavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<NavigationView>(R.id.navView)
            .setupWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeButtonEnabled(true)

        //spinner (dropdownlist plaatsen)
        // access the items of the list
        val plaatsen = resources.getStringArray(R.array.Plaatsen)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, plaatsen)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivity,
                        getString(R.string.selected_item) + " " +
                                "" + plaatsen[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun ClickMenu(view: View){
        //open drawer
        openDrawer(drawerLayout)
    }

    private  fun  openDrawer(drawerLayout: DrawerLayout) {
    //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START)
    }

     fun ClickBack(view: View) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun lockDrawer() {
       drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    override fun unlockDrawer() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.NavHostFragment)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        when (menuItem.itemId) {
            R.id.profielFragment -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.layoutToolBar, profielFragment())
                    .commit()
                drawerLayout.close()
            }
        }
        return true
    }


}