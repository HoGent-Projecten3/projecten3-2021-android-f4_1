package com.example.faithandroid.shoppingCenter

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.toColor
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
import com.sdsmdg.harjot.vectormaster.VectorMasterView
import kotlinx.android.synthetic.main.shoppingcenter.view.*


class ShoppingCenterFragment: Fragment() {
    private lateinit var viewModel: ShoppingCenterViewModel
    private lateinit var vectorMasterView: VectorMasterView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
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
        this.vectorMasterView = binding.imgAvatar as VectorMasterView

        viewModel = ViewModelProvider(this).get(ShoppingCenterViewModel::class.java)
        binding.shoppingCenterViewModel = viewModel


        binding.hairGridView.adapter = ShoppingCenterGridAdapter(BodyType.Hair, object: AvatarCustomClick {
            override fun onClick(avatarpart: Int){
                var path1 = vectorMasterView.getPathModelByName("Hair1")
                var path2 = vectorMasterView.getPathModelByName("Hair2")
                path1.fillColor = avatarpart
                path2.fillColor = avatarpart
                vectorMasterView.update()
            }
        })

        binding.eyeGridView.adapter = ShoppingCenterGridAdapter(BodyType.Eye, object: AvatarCustomClick {
            override fun onClick(avatarpart: Int){

                var path1 = vectorMasterView.getPathModelByName("Eye1")
                var path2 = vectorMasterView.getPathModelByName("Eye2")
                path1.fillColor = avatarpart
                path2.fillColor = avatarpart
                vectorMasterView.update()


            }
        })

        binding.skinGridView.adapter = ShoppingCenterGridAdapter(BodyType.Skin, object: AvatarCustomClick {
            override fun onClick(avatarpart: Int){
                var path1 = vectorMasterView.getPathModelByName("Skin1")
                var path2 = vectorMasterView.getPathModelByName("Skin2")
                var path3 = vectorMasterView.getPathModelByName("Skin3")
                var path4 = vectorMasterView.getPathModelByName("Skin4")
                path1.fillColor = avatarpart
                path2.fillColor = avatarpart
                path3.fillColor = avatarpart
                path4.fillColor = avatarpart
                vectorMasterView.update()
            }
        })

        binding.bodyGridView.adapter = ShoppingCenterGridAdapter(BodyType.Body, object:AvatarCustomClick{
            override fun onClick(avatarpart:Int){
                var path1 = vectorMasterView.getPathModelByName("Body")
                path1.fillColor = avatarpart
                vectorMasterView.update()
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

        var drawing: VectorDrawable = this.context?.let { AppCompatResources.getDrawable(it, R.drawable.ic_avatar_female) } as VectorDrawable

        Log.d("drawing", drawing.toString())



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