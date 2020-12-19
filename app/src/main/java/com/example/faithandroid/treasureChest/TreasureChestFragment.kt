package com.example.faithandroid.treasureChest

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
import com.example.faithandroid.adapters.PostAdapter
import com.example.faithandroid.databinding.TreasurechestBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.post.PostViewModel
import com.example.faithandroid.util.Status
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject


class TreasureChestFragment: Fragment() {

    val postRepository : PostRepository by inject()
    private val postViewModel: PostViewModel by lazy{
        ViewModelProvider(this, ViewModelFactory(PlaceType.Schatkist,postRepository)).get(PostViewModel::class.java)
    }

    private lateinit var  adapter: PostAdapter
    private val loadingDialogFragment by lazy { LoadingFragment() }

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
        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = postViewModel

        this.adapter = PostAdapter(object : CustomClick {
            override fun onClick(post: Post) {
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

                    postViewModel.deletePostByEmail(post.id,  PlaceType.Schatkist)
                    postViewModel.postList
                }
            })

        postViewModel.status.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, postViewModel.status.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    R.string.tryAgain
                )
                {
                    postViewModel.getPostsOfPlace(PlaceType.Schatkist)
                }.show()
            }
        })

        postViewModel.postList.observe(this.viewLifecycleOwner, Observer{

            this.adapter.notifyDataSetChanged()
        })

       /* postViewModel.postList.observe(this.viewLifecycleOwner, Observer
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
        })*/

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
