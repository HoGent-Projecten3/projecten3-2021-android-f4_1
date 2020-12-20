package com.example.faithandroid.shoppingCenter

import android.graphics.Color
import android.graphics.drawable.VectorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.*
import com.example.faithandroid.databinding.ShoppingcenterBinding
import com.google.android.material.snackbar.Snackbar
import com.sdsmdg.harjot.vectormaster.VectorMasterView

/**
 * This is a fragment for the shopping center
 */
class ShoppingCenterFragment: Fragment() {

    /**
     * @param viewModel is the viewModel for the avatar
     * @param vectorMasterViewA is the vector that is used when the user chooses person A
     * @param vectorMasterViewB is the vector that is used when the user chooses person B
     * @param character is the person the user has chosen
     * @param hair is the haircolor the user has chosen
     * @param eyes is the eyecolor the user has chosen
     * @param skin is the skintone the user has chosen
     * @param body is the color of the clothes the user has chosen
     */
    private lateinit var viewModel: AvatarViewModel
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

        viewModel = ViewModelProvider(this).get(AvatarViewModel::class.java)
        binding.shoppingCenterViewModel = viewModel

        hair.let { ColorSvgs.setHair(it, vectorMasterViewA, vectorMasterViewB) }
        eyes.let { ColorSvgs.setEyes(it, vectorMasterViewA, vectorMasterViewB) }
        skin.let { ColorSvgs.setSkin(it, vectorMasterViewA, vectorMasterViewB) }
        body.let { ColorSvgs.setBody(it, vectorMasterViewA, vectorMasterViewB) }
        if (character == 0){
            binding.imgAvatarB.setVisibility(View.GONE)
        } else {
            binding.imgAvatarA.setVisibility(View.GONE)
        }

        binding.hairGridView.adapter = ShoppingCenterGridAdapter(BodyType.Hair, object: AvatarCustomClick {
            override fun onClick(avatarpart: Int){
                hair = avatarpart
                avatarpart.let { ColorSvgs.setHair(it, vectorMasterViewA, vectorMasterViewB) }
            }
        })

        binding.eyeGridView.adapter = ShoppingCenterGridAdapter(BodyType.Eye, object: AvatarCustomClick {
            override fun onClick(avatarpart: Int){
                eyes = avatarpart
                avatarpart.let { ColorSvgs.setEyes(it, vectorMasterViewA, vectorMasterViewB) }
            }
        })

        binding.skinGridView.adapter = ShoppingCenterGridAdapter(BodyType.Skin, object: AvatarCustomClick {
            override fun onClick(avatarpart: Int){
                skin = avatarpart
                avatarpart.let { ColorSvgs.setSkin(it, vectorMasterViewA, vectorMasterViewB) }
            }
        })

        binding.bodyGridView.adapter = ShoppingCenterGridAdapter(BodyType.Body, object:AvatarCustomClick{
            override fun onClick(avatarpart:Int){
                body = avatarpart
                avatarpart.let { ColorSvgs.setBody(it, vectorMasterViewA, vectorMasterViewB) }
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


        viewModel.currentAvatar.observe(this.viewLifecycleOwner, Observer{
            character = viewModel.currentAvatar.value?.person!!
            if (character == 0){
                binding.imgAvatarA.setVisibility(View.VISIBLE)
                binding.imgAvatarB.setVisibility(View.GONE)
            } else {
                binding.imgAvatarA.setVisibility(View.GONE)
                binding.imgAvatarB.setVisibility(View.VISIBLE)
            }

            hair = viewModel.currentAvatar.value?.hair!!
            hair.let { ColorSvgs.setHair(it, vectorMasterViewA, vectorMasterViewB) }

            eyes = viewModel.currentAvatar.value?.eyes!!
            eyes.let { ColorSvgs.setEyes(it, vectorMasterViewA, vectorMasterViewB) }

            skin = viewModel.currentAvatar.value?.skin!!
            skin.let { ColorSvgs.setSkin(it, vectorMasterViewA, vectorMasterViewB) }

            body = viewModel.currentAvatar.value?.upperBody!!
            body.let { ColorSvgs.setBody(it, vectorMasterViewA, vectorMasterViewB) }
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
}