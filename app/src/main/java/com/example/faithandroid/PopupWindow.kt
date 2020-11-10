package com.example.faithandroid

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import androidx.core.graphics.ColorUtils
import kotlinx.android.synthetic.main.bulletinboard_activity_popup_window.*

class PopupWindow : AppCompatActivity() {
    private var popupTitle = ""
    private var popupText = ""
    private var popupButton = ""
    private var darkStatusBar = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(0,0)
        setContentView(R.layout.bulletinboard_activity_popup_window)


/// hoort bij elkaar



        val bundle = intent.extras
        popupTitle = bundle?.getString("popuptitle", "Title") ?: ""
        popupText = bundle?.getString("popuptext", "Text") ?: ""
        popupButton = bundle?.getString("popupbtn", "Button") ?: ""
        darkStatusBar = bundle?.getBoolean("darkstatusbar", false) ?: false

        popup_window_title.text = popupTitle
        popup_window_text.text = popupText
        popup_window_button.text = popupButton


        val alpha = 100 //between 0-255
        val alphaColor = ColorUtils.setAlphaComponent(Color.parseColor("#000000"), alpha)
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), Color.TRANSPARENT, alphaColor)
        colorAnimation.duration = 500 // milliseconds
        colorAnimation.addUpdateListener { animator ->
            popup_window_background.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()

        popup_window_view_with_border.alpha = 0f
        popup_window_view_with_border.animate().alpha(1f).setDuration(500).setInterpolator(
            DecelerateInterpolator()
        ).start()

        popup_window_button.setOnClickListener {
            onBackPressed()
        }
    }

}