package com.example.faithandroid.shoppingCenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.AvatarCustomClick
import com.example.faithandroid.BodyType
import com.example.faithandroid.R
import com.example.faithandroid.databinding.ShoppingcenterBinding
import com.google.android.material.snackbar.Snackbar


class ShoppingCenterFragment: Fragment() {
    private lateinit var viewModel: ShoppingCenterViewModel

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

        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(ShoppingCenterViewModel::class.java)
        binding.shoppingCenterViewModel = viewModel


        binding.hairGridView.adapter = ShoppingCenterGridAdapter(BodyType.Hair, object: AvatarCustomClick {
            override fun onClick(avatarpart: Int){
                var drawable = this@ShoppingCenterFragment.context?.let { AppCompatResources.getDrawable(it, R.drawable.ic_avatar_female) }
                //val path1: VFullPath = vector.findPathByName("path1")
            }
        })

        binding.eyeGridView.adapter = ShoppingCenterGridAdapter(BodyType.Eye, object: AvatarCustomClick {
            override fun onClick(avatarpart: Int){
                var drawable = this@ShoppingCenterFragment.context?.let { AppCompatResources.getDrawable(it, R.drawable.ic_avatar_female) }
            }
        })

        binding.skinGridView.adapter = ShoppingCenterGridAdapter(BodyType.Skin, object: AvatarCustomClick {
            override fun onClick(avatarpart: Int){
                var drawable = this@ShoppingCenterFragment.context?.let { AppCompatResources.getDrawable(it, R.drawable.ic_avatar_female) }
            }
        })

        binding.bodyGridView.adapter = ShoppingCenterGridAdapter(BodyType.Body, object:AvatarCustomClick{
            override fun onClick(avatarpart:Int){
                var drawable = this@ShoppingCenterFragment.context?.let { AppCompatResources.getDrawable(it, R.drawable.ic_avatar_female) }
            }
        })

        val hairLayoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        val eyeLayoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        val skinLayoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        val bodyLayoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)

        val hairList = binding.hairGridView as RecyclerView
        val eyeList = binding.eyeGridView as RecyclerView
        val skinList = binding.skinGridView as RecyclerView
        val bodyList = binding.bodyGridView as RecyclerView

        hairList.layoutManager = hairLayoutManager
        eyeList.layoutManager = eyeLayoutManager
        skinList.layoutManager = skinLayoutManager
        bodyList.layoutManager = bodyLayoutManager

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
                    viewModel.getProperties()
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