package com.example.faithandroid.shoppingCenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.faithandroid.R
import com.example.faithandroid.billboard.BillboardGridAdapter
import com.example.faithandroid.billboard.BillboardViewModel
import com.example.faithandroid.databinding.ShoppingcenterBinding
import com.example.faithandroid.databinding.TabHairBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.google.android.material.tabs.TabLayoutMediator

class HairFragment: Fragment() {

    private lateinit var viewModel: ShoppingCenterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TabHairBinding>(
            inflater,
            R.layout.shoppingcenter,
            container,
            false
        );


        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(ShoppingCenterViewModel::class.java)
        binding.shoppingCenterViewModel = viewModel


        return binding.root
    }
}
