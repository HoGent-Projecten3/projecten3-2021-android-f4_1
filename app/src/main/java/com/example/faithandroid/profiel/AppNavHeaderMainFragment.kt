package com.example.faithandroid.profiel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.faithandroid.R
import com.example.faithandroid.databinding.AppNavHeaderMainBinding
import com.example.faithandroid.databinding.ProfielBinding

class AppNavHeaderMainFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<AppNavHeaderMainBinding>(
            inflater,
            R.layout.app_nav_header_main,
            container,
            false
        );
        return binding.root
    }
}