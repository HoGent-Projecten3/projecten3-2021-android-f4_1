package com.example.faithandroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout

import androidx.lifecycle.ViewModelProvider

import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.faithandroid.databinding.AppNavHeaderMainBinding
import com.example.faithandroid.login.uilogin.LoginActivity
import com.example.faithandroid.login.uilogin.LoginViewModel
import com.example.faithandroid.login.uilogin.LoginViewModelFactory
import com.example.faithandroid.profiel.profielFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.view.*


//import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity(),DrawerInterface,NavigationView.OnNavigationItemSelectedListener {
    
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var viewModel: LoginViewModel
    private  var username: String = ""





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

        AppPreferences.setup(applicationContext)

        val taskIntent =  Intent(this,LoginActivity::class.java)
        startActivityForResult(taskIntent, 1)

        viewModel = ViewModelProvider(this,
            LoginViewModelFactory()
        )
            .get(LoginViewModel::class.java)
        viewModel.adolescent.value?.name?.let { Log.d("ADOLESCETN", it) }
        drawerLayout = findViewById(R.id.drawerLayout)
        var navHeader = findViewById<NavigationView>(R.id.navView)
        var bind = DataBindingUtil.inflate<AppNavHeaderMainBinding>(layoutInflater, R.layout.app_nav_header_main, navHeader.navView , false)
        navHeader.navView.addHeaderView(bind.root)
        bind.adolescent = username
      // var navHeader2 = findViewById<AppNavHeaderMainBinding>(R.id.) as AppNavHeaderMainBinding
//        navHeader2.adolescent = viewModel

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        this.username = data?.getStringExtra("loggedInUser").toString()
        var token = data?.getStringExtra("token").toString();

        AppPreferences.token = token
        AppPreferences.username = this.username
//
//        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
//        with (sharedPref.edit()) {
//            putString("username", data?.getStringExtra("loggedInUser").toString())
//            apply()
//        }


        Log.d("sharedPref", AppPreferences.token.toString())
    }


}