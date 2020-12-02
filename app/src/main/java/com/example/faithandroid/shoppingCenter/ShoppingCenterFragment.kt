package com.example.faithandroid.shoppingCenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.faithandroid.R
import com.example.faithandroid.billboard.BillboardGridAdapter
import com.example.faithandroid.billboard.BillboardViewModel
import com.example.faithandroid.databinding.ShoppingcenterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.google.android.material.tabs.TabLayoutMediator
import example.javatpoint.com.kotlintablayoutexample.ShoppingCenterTabAdapter

class ShoppingCenterFragment: Fragment() {
    private lateinit var viewModel: ShoppingCenterViewModel
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ShoppingcenterBinding>(
            inflater,
            R.layout.shoppingcenter,
            container,
            false
        );

        tabLayout = binding.tablayout
        viewPager = binding.pager

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Haar"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Ogen"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Huid"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Lichaam"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL


        val tabAdapter = ShoppingCenterTabAdapter(this.context,
            activity?.supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = tabAdapter


        viewPager!!.registerOnPageChangeCallback(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(ShoppingCenterViewModel::class.java)
        binding.shoppingCenterViewModel = viewModel

        binding.shoppingCenterGridView.adapter = ShoppingCenterGridAdapter()

        /*binding.ClothesTab.setOnClickListener{
            this.context?.let { context ->
                viewModel.getUpperBody()
            }
        }*/

        viewModel.status.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(
                    contextView,
                    "Kon niet verbinding maken met de server",
                    Snackbar.LENGTH_SHORT
                ).setAction(
                    R.string.tryAgain
                )
                {
                    viewModel.getPosts()
                }.show()
            }
        })

        /*viewPager = findViewById(R.id.viewPager)
        binding.tablayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })*/


        return binding.root
    }
}