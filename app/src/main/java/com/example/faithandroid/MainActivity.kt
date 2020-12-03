package com.example.faithandroid


import AppPreferences
import android.content.Intent
import android.net.Uri

import android.content.Context
import android.Manifest
import android.content.Intent
import android.graphics.Path
import android.content.pm.PackageManager

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.faithandroid.databinding.AppNavHeaderMainBinding
import com.example.faithandroid.login.LoginFragment
import com.example.faithandroid.login.uilogin.LoginActivity
import com.example.faithandroid.login.uilogin.LoginViewModel
import com.example.faithandroid.login.uilogin.LoginViewModelFactory
import com.example.faithandroid.profiel.ProfielViewModel
import com.example.faithandroid.profiel.profielFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse

import kotlinx.android.synthetic.main.activity_main.view.*


//import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity(),DrawerInterface,NavigationView.OnNavigationItemSelectedListener {
    
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var viewModel: LoginViewModel
    private  var username: String = ""

    private lateinit var bind: AppNavHeaderMainBinding
    private val LOGIN_REQUEST_CODE: Int = 1

    private val CLIENT_ID = "95bc88d8f6084f1893dd648d88732210"
    private val REDIRECT_URI = "faithandroid://callback"
    private lateinit var spotifyAppRemoteLocal: SpotifyAppRemote
    private val REQUEST_CODE = 1337


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

        AppPreferences.setup(applicationContext)

        val taskIntent =  Intent(this, LoginActivity::class.java)

        startActivityForResult(taskIntent, LOGIN_REQUEST_CODE)


        viewModel = ViewModelProvider(
            this,
            LoginViewModelFactory()
        )
            .get(LoginViewModel::class.java)

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
        var pvm: ProfielViewModel = ViewModelProvider(this).get(ProfielViewModel::class.java)
        pvm.getAdolescent()
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
                supportFragmentManager.beginTransaction()
                    .replace(R.id.layoutToolBar, profielFragment())
                    .commit()
            }
            R.id.loginFragment -> {

                viewModel.logout()
                this.username = ""
                AppPreferences.token = ""
                AppPreferences.username = ""
                supportFragmentManager.beginTransaction()
                    .replace(R.id.layoutToolBar, LoginFragment())
                    .commit()

                //finishAffinity()
                Toast.makeText(this, "Logged out!", Toast.LENGTH_LONG).show()
                Log.d("Token", AppPreferences.token.toString())

                val taskIntent = Intent(this, LoginActivity::class.java)
                startActivityForResult(taskIntent, 1)

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


        Log.d("sharedPref", AppPreferences.token.toString())

    }

    override fun onStart()
    {
        super.onStart()


    }


    override fun onStop()
    {
        super.onStop()

    }


}



