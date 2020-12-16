package com.example.faithandroid.backpack

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.faithandroid.*
import com.example.faithandroid.adapters.PostAdapter
import com.example.faithandroid.databinding.BackpackBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.post.PostViewModel
import com.example.faithandroid.util.Status
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject


class BackpackFragment: Fragment(), CustomClick {

    private lateinit var postAdapter: PostAdapter
    private lateinit var dropdownList: AutoCompleteTextView
    private val loadingDialogFragment by lazy { LoadingFragment() }
    val postRepository : PostRepository by inject()
    private val postViewModel: PostViewModel by lazy{
        ViewModelProvider(this, ViewModelFactory(PlaceType.Schatkist,postRepository)).get(PostViewModel::class.java)
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

        // staggeredGridLayoutManager with 3 columns and vertical orientation
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.BackpackRecycler.layoutManager = staggeredGridLayoutManager

        val postTypes =  PostType.values()

        val adapter1 = this.context?.let {
            ArrayAdapter<PostType>(
                it,
                R.layout.dropdown_menu_popup_item_extra,
                PostType.values()
            )
        }
        dropdownList = binding.dropdownFilter
        dropdownList.setAdapter(adapter1)
        dropdownList.setText("Alles", false)
        dropdownList.setOnItemClickListener { parent, view, position, id ->

            postViewModel.getFilteredPostFromPlace(
                PlaceType.Rugzak,
                postTypes[position]
            )

        }
        binding.postViewModel = postViewModel

        binding.closeFilterBtn.setOnClickListener{
            postViewModel.postList
        }

        binding.AddPostButton.setOnClickListener { view: View ->
            val action =
                BackpackFragmentDirections.actionBackpackFragmentToOptionsAddPostFragment(
                    PlaceType.Rugzak
                )
            view.findNavController().navigate(action)
        }




        postAdapter = PostAdapter(this)

        binding.BackpackRecycler.adapter =
            PostAdapter(object : CustomClick {
                override fun onClick(post: Post) {
                    postViewModel.pemanentlyDeletePost(post.id)
                    true
                    //postViewModel.postList
                }

            }
            )
                postViewModel.postList.observe(this.viewLifecycleOwner, Observer
                {
                    it?.let { resource ->
                        when (resource.status) {
                            Status.SUCCESS -> {
                                showProgress(false)
                                postAdapter.submitList(resource.data)
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


            override fun onStart() {
                super.onStart()
            }

            override fun onResume() {
                val adapter = this.context?.let {
                    ArrayAdapter<PostType>(
                        it,
                        R.layout.dropdown_menu_popup_item_extra,
                        PostType.values()
                    )
                }

                dropdownList.setAdapter(adapter)
                super.onResume()
            }

            private fun showProgress(b: Boolean) {
                if (b) {
                    if (!loadingDialogFragment.isAdded) {
                        loadingDialogFragment.show(
                            requireActivity().supportFragmentManager,
                            "loader"
                        )
                    }
                } else {
                    if (loadingDialogFragment.isAdded) {
                        loadingDialogFragment.dismissAllowingStateLoss()
                    }
                }
            }

            override fun onClick(post: Post) {
                TODO("Not yet implemented")
            }
        }
