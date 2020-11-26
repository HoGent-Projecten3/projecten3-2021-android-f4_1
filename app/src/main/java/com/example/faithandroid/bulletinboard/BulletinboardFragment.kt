package com.example.faithandroid.bulletinboard

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
import com.example.faithandroid.databinding.BulletinboardBinding
import com.example.faithandroid.adapters.PostAdapter
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar


class BulletinboardFragment: Fragment() {

    private lateinit var viewModel: BulletinBoardViewModel
    private val postViewModel: PostViewModel by lazy{
        ViewModelProvider(this, ViewModelFactory(PlaceType.Prikbord)).get(PostViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<BulletinboardBinding>(
          inflater,
          R.layout.bulletinboard,
          container,
          false
      );

        binding.lifecycleOwner = this

        binding.requestConsultationButton.setOnClickListener {
            this.context?.let { context ->
                MaterialAlertDialogBuilder(context)
                    .setTitle(R.string.aanvraag_gesprek_dialogbox)
                    .setMessage(R.string.aanvraag_gesprek_dialogbox_message)

                    .setPositiveButton("Ja") { dialog, which ->
                        // Respond to positive button press
                        viewModel.requestConsultation()
                        this.view?.let { view ->
                            viewModel.requestConsultationStatus.value?.let { string ->
                                Snackbar.make(view, string, Snackbar.LENGTH_SHORT)
                                    .show()
                            }
                        }

                    }
                    .setNegativeButton("Nee")
                    {
                        dialog, which ->
                    }
                    .show()
            }

        }

        binding.AddPostButton.setOnClickListener { view: View ->
            val action =
                BulletinboardFragmentDirections.actionBulletinBoardFragmentToOptionsAddPostFragment(
                    PlaceType.Prikbord
                )
            view.findNavController().navigate(action)
        }

        viewModel = ViewModelProvider(this).get(BulletinBoardViewModel::class.java)

        binding.viewModel = postViewModel
        binding.BulletinBoardRecycler.adapter =
            PostAdapter(object : CustomClick {
                override fun onClick(post: Post) {

                    postViewModel.deletePostByEmail(post.id, "dora.theexplorer1999@gmail.com", PlaceType.Prikbord)
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
                    //viewModel.getPostsOfBulletinBoard()
                }.show()
            }
        })

        return binding.root
    }
}