package com.example.faithandroid.backpack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.*
import com.example.faithandroid.adapters.FilteredPostAdapter
import com.example.faithandroid.adapters.PostAdapter
import com.example.faithandroid.databinding.BackpackBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostViewModel
import com.google.android.material.snackbar.Snackbar


class BackpackFragment: Fragment() {

    private lateinit var viewModel: BackpackViewModel
    private val postViewModel: PostViewModel by lazy{
        ViewModelProvider(this, ViewModelFactory(PlaceType.Rugzak)).get(PostViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<BackpackBinding>(
          inflater,
          R.layout.backpack,
          container,
          false
      );

        binding.lifecycleOwner = this

        binding.AddPostButton.setOnClickListener { view: View ->
            val action =
                BackpackFragmentDirections.actionBackpackFragmentToOptionsAddPostFragment(
                    PlaceType.Rugzak
                )
            view.findNavController().navigate(action)
        }

        viewModel = ViewModelProvider(this).get(BackpackViewModel::class.java)
        binding.viewModel = postViewModel
        binding.BackpackRecycler.adapter =  FilteredPostAdapter(object : CustomClick {
            override fun onClick(post: Post) {
                true
            }
        })

        binding.BackpackRecycler.adapter =
            PostAdapter(object : CustomClick {
                override fun onClick(post: Post) {
                    postViewModel.deletePostByEmail(post.id, "dora.theexplorer1999@gmail.com", PlaceType.Rugzak)
                    true
                }
            })

        postViewModel.status.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, viewModel.status.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    R.string.tryAgain
                )
                {

                }.show()
            }
        })
        return binding.root
    }
}