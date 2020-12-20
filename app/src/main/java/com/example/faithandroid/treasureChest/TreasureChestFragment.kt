package com.example.faithandroid.treasureChest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.*
import com.example.faithandroid.adapters.PostAdapter
import com.example.faithandroid.databinding.TreasurechestBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.post.PostViewModel
import org.koin.android.ext.android.inject

/**
 * This is a fragment for the treasure chest
 *
 * @property postViewModel is the viewmodel that is used by posts
 * @property adapter is the adapter that binds the posts in treasure chest to the recyclerview
 */
class TreasureChestFragment : Fragment() {
    val postRepository: PostRepository by inject()

    private val postViewModel: PostViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory(PlaceType.Schatkist, postRepository)).get(PostViewModel::class.java)
    }

    private lateinit var adapter: PostAdapter
    private val loadingDialogFragment by lazy { LoadingFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<TreasurechestBinding>(
          inflater,
          R.layout.treasurechest,
          container,
          false
      )
        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = postViewModel

        this.adapter = PostAdapter(
            object : CustomClick {
override fun onClick(post: Post) {
}
}
        )

        binding.TreasureChestRecycler?.adapter = this.adapter

        binding.AddPostButton.setOnClickListener { view: View ->
            val action =
                TreasureChestFragmentDirections.actionTreasureChestFragmentToOptionsAddPostFragment(
                    PlaceType.Schatkist
                )
            view.findNavController().navigate(action)
        }

        binding.TreasureChestRecycler?.adapter =
            PostAdapter(
                object : CustomClick {
        override fun onClick(post: Post) {
            postViewModel.deletePostByEmail(post.id, PlaceType.Schatkist)
            postViewModel.postList
            true
        }
    }
            )

        return binding.root
    }
}
