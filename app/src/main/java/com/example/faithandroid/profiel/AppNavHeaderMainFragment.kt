package com.example.faithandroid.profiel

import AppPreferences
import ColorSvgs
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.AvatarViewModel
import com.example.faithandroid.R
import com.example.faithandroid.databinding.AppNavHeaderMainBinding
import com.sdsmdg.harjot.vectormaster.VectorMasterView

/**
 * This fragment is unused, we configure the appnavheadermain in mainActivity
 */
class AppNavHeaderMainFragment : Fragment() {
    private lateinit var viewModel: AvatarViewModel
    private lateinit var vectorMasterViewA: VectorMasterView
    private lateinit var vectorMasterViewB: VectorMasterView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<AppNavHeaderMainBinding>(
            inflater,
            R.layout.app_nav_header_main,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(AvatarViewModel::class.java)

        this.vectorMasterViewA = binding.imgAvatarA as VectorMasterView
        this.vectorMasterViewB = binding.imgAvatarB as VectorMasterView

        AppPreferences.currentHair?.let { ColorSvgs.setHair(it, vectorMasterViewA, vectorMasterViewB) }
        AppPreferences.currentEyes?.let { ColorSvgs.setEyes(it, vectorMasterViewA, vectorMasterViewB) }
        AppPreferences.currentSkin?.let { ColorSvgs.setSkin(it, vectorMasterViewA, vectorMasterViewB) }
        AppPreferences.currentBody?.let { ColorSvgs.setBody(it, vectorMasterViewA, vectorMasterViewB) }

        if (AppPreferences.currentPerson == 0) {
            binding.imgAvatarB.setVisibility(View.GONE)
        } else {
            binding.imgAvatarA.setVisibility(View.GONE)
        }

        viewModel.currentAvatar.observe(
            this.viewLifecycleOwner,
            Observer {
                if (AppPreferences.currentPerson == 0) {
                            binding.imgAvatarA.setVisibility(View.VISIBLE)
                            binding.imgAvatarB.setVisibility(View.GONE)
                        } else {
                            binding.imgAvatarA.setVisibility(View.GONE)
                            binding.imgAvatarB.setVisibility(View.VISIBLE)
                        }

                        it.let { it -> ColorSvgs.setHair(it.hair, vectorMasterViewA, vectorMasterViewB) }
                        it.let { it -> ColorSvgs.setEyes(it.eyes, vectorMasterViewA, vectorMasterViewB) }
                        it.let { it -> ColorSvgs.setSkin(it.skin, vectorMasterViewA, vectorMasterViewB) }
                        it.let { it -> ColorSvgs.setBody(it.upperBody, vectorMasterViewA, vectorMasterViewB) }
            }
        )

        return binding.root
    }
}
