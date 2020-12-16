package com.example.faithandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.faithandroid.databinding.AppHomeschermBinding
import com.example.faithandroid.profiel.ProfielFragment
import com.google.android.material.navigation.NavigationView
import com.squareup.picasso.Picasso

//import androidx.databinding.DataBindingUtil

class HomeActivity : AppCompatActivity() {


   // private lateinit var drawerLayout : DrawerLayout
    private lateinit var imageView: ImageView
    private var imageUri: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_homescherm)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeButtonEnabled(true)

    }

    // button links onderaan (driehoek) 
    override fun onBackPressed() {
        super.onBackPressed()

    }

}