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
import com.example.faithandroid.UI.LoadingFragment
import com.example.faithandroid.adapters.FilteredPostAdapter
import com.example.faithandroid.adapters.PostAdapter
import com.example.faithandroid.data.local.PostDao
import com.example.faithandroid.data.local.PostLocalDataSource
import com.example.faithandroid.data.remote.PostRemoteDataSource
import com.example.faithandroid.databinding.BackpackBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.post.PostViewModel
import com.example.nativeapps.util.Status
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject


class BackpackFragment: Fragment() {

    //private lateinit var postDao: PostDao
    private lateinit var adapter: PostAdapter
   //private lateinit var viewModel: PostViewModel
    /*private val postViewModel: PostViewModel by lazy{
        ViewModelProvider(this, ViewModelFactory(PlaceType.Schatkist, PostRepository(
            PostLocalDataSource(object: PostDao),
            PostRemoteDataSource(FaithApi)
        ))).get(PostViewModel::class.java)
    }*/
    private val loadingDialogFragment by lazy { LoadingFragment() }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val postViewModel : PostViewModel by inject()
        val binding = DataBindingUtil.inflate<BackpackBinding>(

            inflater,
          R.layout.backpack,
          container,
          false
      )
        adapter =  PostAdapter(object : CustomClick {
            override fun onClick(post: Post) {
                postViewModel.deletePostByEmail(post.id, "dora.theexplorer1999@gmail.com", PlaceType.Rugzak)
                true
            }
        })
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = postViewModel

        binding.BackpackRecycler.adapter =  adapter

        /*binding.BackpackRecycler.adapter =
            PostAdapter(object : CustomClick {
                override fun onClick(post: Post) {
                    postViewModel.deletePostByEmail(post.id, "dora.theexplorer1999@gmail.com", PlaceType.Rugzak)
                    true
                }
            })*/


        binding.AddPostButton.setOnClickListener { view: View ->
            val action =
                BackpackFragmentDirections.actionBackpackFragmentToOptionsAddPostFragment(
                    PlaceType.Rugzak
                )
            view.findNavController().navigate(action)
        }

        //viewModel = ViewModelProvider(this).get(PostViewModel::class.java)


        postViewModel.repPosts.observe(this.viewLifecycleOwner, Observer
        {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        showProgress(false)
                      adapter.submitList(resource.data)
                    }
                    Status.LOADING -> {
                        showProgress(true)
                    }
                    Status.ERROR -> {
                        showProgress(false)
                    }
                }
            }
        })
        return binding.root
    }

    private fun showProgress(b: Boolean) {
        if (b) {
            if (!loadingDialogFragment.isAdded) {
                loadingDialogFragment.show(requireActivity().supportFragmentManager, "loader")
            }
        } else {
            if (loadingDialogFragment.isAdded) {
                loadingDialogFragment.dismissAllowingStateLoss()
            }
        }
    }
}