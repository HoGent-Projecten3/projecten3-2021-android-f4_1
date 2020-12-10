

package com.example.faithandroid



import AppPreferences
import android.content.Intent

import android.Manifest

import android.content.pm.PackageManager

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity

import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat



import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe

import androidx.navigation.ActivityNavigator

import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.faithandroid.databinding.AppNavHeaderMainBinding
import com.example.faithandroid.login.LoginFragment
import com.example.faithandroid.login.uilogin.LoginActivity
import com.example.faithandroid.login.uilogin.LoginViewModel
import com.example.faithandroid.profiel.ProfielViewModel
import com.example.faithandroid.profiel.ProfielFragment
import com.google.android.material.navigation.NavigationView


import kotlinx.android.synthetic.main.activity_main.view.*
import org.koin.android.ext.android.inject


//import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity(), DrawerInterface,NavigationView.OnNavigationItemSelectedListener {
    
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private  var username: String = ""
    val viewModel : LoginViewModel by inject()

    private lateinit var bind: AppNavHeaderMainBinding
    private val LOGIN_REQUEST_CODE: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

        AppPreferences.setup(applicationContext)

        if (AppPreferences.darkMode == true){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

        if (AppPreferences.username == null) {
            val taskIntent =  Intent(this, LoginActivity::class.java)
            startActivityForResult(taskIntent, LOGIN_REQUEST_CODE)
        }

        drawerLayout = findViewById(R.id.drawerLayout)
        var navHeader = findViewById<NavigationView>(R.id.navView)
        bind = DataBindingUtil.inflate<AppNavHeaderMainBinding>(
            layoutInflater,
            R.layout.app_nav_header_main,
            navHeader.navView,
            false
        )

        navHeader.navView.addHeaderView(bind.root)


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

        //eerst controleren of de gebruiker daadwerkelijk permissie heeft gegeven om audio op te nemen
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            val permissions = arrayOf(android.Manifest.permission.RECORD_AUDIO, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE)
            ActivityCompat.requestPermissions(this, permissions,0)
        }

       val navigationView: NavigationView = findViewById(R.id.navView)
       navigationView.setNavigationItemSelectedListener(this)

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
        val pvm: ProfielViewModel by inject()
        //pvm.getAdolescent()
        pvm.adol.observe(this, {
            username = it.firstName + " " + it.name
            bind.nameText.text = username
        })
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

//                 supportFragmentManager.beginTransaction()
//                    .replace(R.id.layoutToolBar, ProfielFragment())
//
//                    .commit()

                menuItem.onNavDestinationSelected(findNavController(R.id.NavHostFragment))
            }
            R.id.loginFragment -> {

                viewModel.logout()
                this.username = ""
                AppPreferences.token = ""
                AppPreferences.username = ""
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.layoutToolBar, LoginFragment())
//                    .commit()


                 //finishAffinity()
                Toast.makeText(this,"Uitgelogd!", Toast.LENGTH_LONG).show()


                val taskIntent = Intent(this, LoginActivity::class.java)
                startActivityForResult(taskIntent, 1)

            }

            R.id.homeFragment -> {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.layoutToolBar, LoginFragment())
//                    .commit()

                menuItem.onNavDestinationSelected(findNavController(R.id.NavHostFragment))
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        //this.username = data?.getStringExtra("loggedInUser").toString()


        if(requestCode == LOGIN_REQUEST_CODE){
            var token = data?.getStringExtra("token").toString();
            AppPreferences.token = token
        }

    }

    override fun finish() {
        super.finish()
        ActivityNavigator.applyPopAnimationsToPendingTransition(this)

    }



}

