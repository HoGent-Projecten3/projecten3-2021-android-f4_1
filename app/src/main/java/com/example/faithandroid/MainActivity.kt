package com.example.faithandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.example.faithandroid.databinding.ActivityTestBinding
import kotlinx.android.synthetic.main.fragment_bulletinboard.*

//import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout : DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityTestBinding>(this, R.layout.menu_homescherm)
        //setContentView(R.layout.menu_homescherm)
        setContentView(R.layout.fragment_login) // to see of the screen is good

        requestConsultationButton.setOnClickListener {
            val intent = Intent(this, PopupWindow::class.java)
            intent.putExtra("popuptitle", "Aanvraag Gesprek")
            intent.putExtra("popuptext", "Uw gesprek werd aangevraagd! \n Uw begeleider zal een melding ontvangen.")
            intent.putExtra("popupbtn", "OK")
            intent.putExtra("darkstatusbar", false)
            startActivity(intent)
        }

        drawerLayout = findViewById(R.id.drawerLayout);

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
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

    fun ClickBack(view: View) {}


}