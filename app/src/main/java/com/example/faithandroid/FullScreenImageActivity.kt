package com.example.faithandroid

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

// import androidx.databinding.DataBindingUtil

class FullScreenImageActivity : AppCompatActivity() {

    // private lateinit var drawerLayout : DrawerLayout
    private lateinit var imageView: ImageView
    private var imageUri: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fullscreen_image)

        imageUri = getIntent().getExtras()!!.getString("imageUri").toString()

        imageView = findViewById<ImageView>(R.id.fullscreen_image)
        Picasso.get().load(imageUri).into(imageView)

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
