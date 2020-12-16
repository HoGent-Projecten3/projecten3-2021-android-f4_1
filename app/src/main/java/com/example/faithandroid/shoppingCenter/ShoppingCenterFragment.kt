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
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.AvatarCustomClick
import com.example.faithandroid.BodyType
import com.example.faithandroid.PlaceType
import com.example.faithandroid.R
import com.example.faithandroid.databinding.ShoppingcenterBinding
import com.example.faithandroid.treasureChest.TreasureChestFragmentDirections
import com.google.android.material.snackbar.Snackbar
import com.sdsmdg.harjot.vectormaster.VectorMasterView
import kotlinx.android.synthetic.main.shoppingcenter.view.*


class ShoppingCenterFragment: Fragment() {
    private lateinit var viewModel: ShoppingCenterViewModel
    private lateinit var vectorMasterViewA: VectorMasterView
    private lateinit var vectorMasterViewB: VectorMasterView

    private var character: Int = 0
    private var hair: Int = Color.parseColor("#FFFFFFFF")
    private var eyes: Int = Color.parseColor("#FFFFFFFF")
    private var skin: Int = Color.parseColor("#FFFFFFFF")
    private var body: Int = Color.parseColor("#FFFFFFFF")

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
        this.vectorMasterViewA = binding.imgAvatarA as VectorMasterView
        this.vectorMasterViewB = binding.imgAvatarB as VectorMasterView

        viewModel = ViewModelProvider(this).get(ShoppingCenterViewModel::class.java)
        binding.shoppingCenterViewModel = viewModel

        setHair(hair)
        setEyes(eyes)
        setSkin(skin)
        setBody(body)
        if (character == 0){
            binding.imgAvatarB.setVisibility(View.GONE)
        } else {
            binding.imgAvatarA.setVisibility(View.GONE)
        }

        binding.hairGridView.adapter = ShoppingCenterGridAdapter(BodyType.Hair, object: AvatarCustomClick {
            override fun onClick(avatarpart: Int){
                setHair(avatarpart)
            }
        })

        binding.eyeGridView.adapter = ShoppingCenterGridAdapter(BodyType.Eye, object: AvatarCustomClick {
            override fun onClick(avatarpart: Int){
                setEyes(avatarpart)
            }
        })

        binding.skinGridView.adapter = ShoppingCenterGridAdapter(BodyType.Skin, object: AvatarCustomClick {
            override fun onClick(avatarpart: Int){
                setSkin(avatarpart)
            }
        })

        binding.bodyGridView.adapter = ShoppingCenterGridAdapter(BodyType.Body, object:AvatarCustomClick{
            override fun onClick(avatarpart:Int){
                setBody(avatarpart)
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

        binding.personA.setOnClickListener { view: View ->
            character = 0
            binding.imgAvatarA.setVisibility(View.VISIBLE)
            binding.imgAvatarB.setVisibility(View.GONE)
        }

        binding.personB.setOnClickListener { view: View ->
            character = 1
            binding.imgAvatarA.setVisibility(View.GONE)
            binding.imgAvatarB.setVisibility(View.VISIBLE)
        }

        binding.savePerson.setOnClickListener { view: View ->
            viewModel.postAvatar(character, hair, eyes, skin, body)
        }

        /*binding.ClothesTab.setOnClickListener{
            this.context?.let { context ->
                viewModel.getUpperBody()
            }
        }*/

        var drawing: VectorDrawable = this.context?.let { AppCompatResources.getDrawable(it, R.drawable.ic_avatar_female) } as VectorDrawable

        Log.d("drawing", drawing.toString())

        viewModel.currentCharacter.observe(this.viewLifecycleOwner, Observer{
            character = viewModel.currentCharacter.value!!
            if (character == 0){
                binding.imgAvatarA.setVisibility(View.VISIBLE)
                binding.imgAvatarB.setVisibility(View.GONE)
            } else {
                binding.imgAvatarA.setVisibility(View.GONE)
                binding.imgAvatarB.setVisibility(View.VISIBLE)
            }
        })

        viewModel.currentHair.observe(this.viewLifecycleOwner, Observer{
            hair = viewModel.currentHair.value!!
            setHair(hair)
        })

        viewModel.currentEyes.observe(this.viewLifecycleOwner, Observer{
            eyes = viewModel.currentEyes.value!!
            setEyes(eyes)
        })

        viewModel.currentSkin.observe(this.viewLifecycleOwner, Observer{
            skin = viewModel.currentSkin.value!!
            setSkin(skin)
        })

        viewModel.currentBody.observe(this.viewLifecycleOwner, Observer{
            body = viewModel.currentBody.value!!
            setBody(body)
        })



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

    fun setHair(avatarpart: Int){
        hair = avatarpart
        var path1 = vectorMasterViewA.getPathModelByName("Hair1")
        var path2 = vectorMasterViewA.getPathModelByName("Hair2")
        var path3 = vectorMasterViewB.getPathModelByName("Hair")
        path1.fillColor = avatarpart
        path2.fillColor = avatarpart
        path3.fillColor = avatarpart
        vectorMasterViewA.update()
        vectorMasterViewB.update()
    }

    fun setEyes(avatarpart: Int){
        eyes = avatarpart
        var path1 = vectorMasterViewA.getPathModelByName("Eye1")
        var path2 = vectorMasterViewA.getPathModelByName("Eye2")
        var path3 = vectorMasterViewB.getPathModelByName("Eye1")
        var path4 = vectorMasterViewB.getPathModelByName("Eye2")
        path1.fillColor = avatarpart
        path2.fillColor = avatarpart
        path3.fillColor = avatarpart
        path4.fillColor = avatarpart
        vectorMasterViewA.update()
        vectorMasterViewB.update()
    }

    fun setSkin(avatarpart: Int){
        skin = avatarpart
        var path1 = vectorMasterViewA.getPathModelByName("Skin1")
        var path2 = vectorMasterViewA.getPathModelByName("Skin2")
        var path3 = vectorMasterViewA.getPathModelByName("Skin3")
        var path4 = vectorMasterViewA.getPathModelByName("Skin4")
        var path5 = vectorMasterViewB.getPathModelByName("Skin1")
        var path6 = vectorMasterViewB.getPathModelByName("Skin2")
        var path7 = vectorMasterViewB.getPathModelByName("Skin3")
        var path8 = vectorMasterViewB.getPathModelByName("Skin4")
        path1.fillColor = avatarpart
        path2.fillColor = avatarpart
        path3.fillColor = avatarpart
        path4.fillColor = avatarpart
        path5.fillColor = avatarpart
        path6.fillColor = avatarpart
        path7.fillColor = avatarpart
        path8.fillColor = avatarpart
        vectorMasterViewA.update()
        vectorMasterViewB.update()
    }

    fun setBody(avatarpart: Int){
        body = avatarpart
        var path1 = vectorMasterViewA.getPathModelByName("Body")
        var path2 = vectorMasterViewB.getPathModelByName("Body")
        path1.fillColor = avatarpart
        path2.fillColor = avatarpart
        vectorMasterViewA.update()
        vectorMasterViewB.update()
    }
}