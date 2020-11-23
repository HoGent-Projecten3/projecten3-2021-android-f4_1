package com.example.faithandroid.treasureChest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.*
import com.example.faithandroid.databinding.TreasurechestBinding
import com.example.faithandroid.models.Post
import com.google.android.material.snackbar.Snackbar


class TreasureChestFragment: Fragment() {

    private val postViewModel: PostViewModel by lazy{
        ViewModelProvider(this, ViewModelFactory(PlaceType.Schatkist)).get(PostViewModel::class.java)
    }

    private lateinit var  adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<TreasurechestBinding>(
          inflater,
          R.layout.treasurechest,
          container,
          false
      );
        binding.lifecycleOwner = this

        binding.viewModel = postViewModel

        this.adapter = PostAdapter(object : CustomClick {
            override fun onClick(post: Post) {
                true
            }
        })

        binding.TreasureChestRecycler.adapter = this.adapter




        binding.AddPostButton.setOnClickListener { view: View ->
            val action =
                TreasureChestFragmentDirections.actionTreasureChestFragmentToOptionsAddPostFragment(
                    PlaceType.Schatkist
                )
            view.findNavController().navigate(action)
        }

        binding.TreasureChestRecycler.adapter =
            PostAdapter(object : CustomClick {
                override fun onClick(post: Post) {

                    postViewModel.deletePostByEmail(post.id, "dora.theexplorer1999@gmail.com", PlaceType.Schatkist)
                    postViewModel.getPostsOfPlace(PlaceType.Schatkist, "dora.theexplorer1999@gmail")
                    true
                }
            })

        postViewModel.status.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, postViewModel.status.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    R.string.tryAgain
                )
                {
                    postViewModel.getPostsOfPlace(PlaceType.Schatkist, "dora.theexplorer1999@gmail.com")
                }.show()
            }
        })

        postViewModel.postList.observe(this.viewLifecycleOwner, Observer{

            this.adapter.notifyDataSetChanged()
        })

        return binding.root
    }




}