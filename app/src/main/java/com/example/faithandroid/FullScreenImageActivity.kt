package com.example.faithandroid

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


/**
 * the activity for showing an image
 *
 * @property imageView is the view of the image
 * @property imageUri is the uri the image needs to come from
 */
class FullScreenImageActivity : AppCompatActivity() {
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

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
