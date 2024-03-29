package com.example.faithandroid.post.text

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.*
import com.example.faithandroid.adapters.FilteredPostAdapter
import com.example.faithandroid.databinding.AddTextBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.post.PostViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject

/**
 * This is a fragment for adding a textpost from one place to another
 *
 * @property args used to store the placetype
 * @property post is the post to be added
 * @property viewModel is the viewmodel for all posts
 */
class AddTextFragment : Fragment() {
    val args: AddTextFragmentArgs by navArgs()
    var post: Post? = null
    private lateinit var viewModel: PostViewModel
    private lateinit var dropdown: Spinner
    val postRepository: PostRepository by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<AddTextBinding>(
            inflater,
            R.layout.add_text,
            container,
            false,
        )
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, ViewModelFactory(args.placeType, postRepository)).get(PostViewModel::class.java)

        viewModel.status.observe(
            this.viewLifecycleOwner,
            Observer {
                val contextView = this.view
                        Snackbar.make(contextView!!, viewModel.status.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                            ""
                        ) {
                }.show()
            }
        )

        binding.imageView4.setOnClickListener {
                view: View -> val action =
            AddTextFragmentDirections.actionAddTextFragmentToTextPostToevoegen(
                args.placeType
            )
            view.findNavController().navigate(action)
        }

        val placeTypes = PlaceType.values()

        val adapter = this.context?.let {
            ArrayAdapter<PlaceType>(
                it,
                R.layout.dropdown_menu_popup_item_extra,
                PlaceType.values()
            )
        }

        binding.filledExposedDropdown.setAdapter(adapter)
        binding.filledExposedDropdown.setText(PlaceType.Rugzak.name, false)

        binding.filledExposedDropdown.setOnItemClickListener { parent, view, position, id ->
            viewModel.getFilteredPostFromPlace(
                placeTypes[position],
                PostType.Text
            )
        }

        viewModel.getFilteredPostFromPlace(
            PlaceType.Rugzak,
            PostType.Text
        )
        binding.viewModel = viewModel
        binding.recyclerView.adapter =
            FilteredPostAdapter(
                object : CustomClick {
override fun onClick(post: Post) {
    this@AddTextFragment.post = post
    true
}
}
            )

        binding.textToevoegenButton.setOnClickListener {
            post?.let { it1 -> viewModel.addExistingPostToPlace(
                it1.id,
                args.placeType
            ) }
            when (args.placeType) {
                PlaceType.Prikbord -> {
                    it.findNavController()
                        .navigate(R.id.action_addTextFragment_to_bulletinBoardFragment)
                }
                PlaceType.Rugzak -> {
                    it.findNavController()
                        .navigate(R.id.action_addTextFragment_to_backpackFragment)
                }
                PlaceType.Schatkist -> {
                    it.findNavController()
                        .navigate(R.id.action_addTextFragment_to_treasureChestFragment)
                }
            }
        }

        return binding.root
    }
}
