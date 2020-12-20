package com.example.faithandroid.bulletinboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.faithandroid.*
import com.example.faithandroid.adapters.PostAdapter
import com.example.faithandroid.databinding.BulletinboardBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.post.PostViewModel
import com.example.faithandroid.util.Status
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.app_bar_back.view.*
import kotlinx.android.synthetic.main.skyscraper_add_goal.view.*
import org.koin.android.ext.android.inject

/**
 * Fragment for the Bulletinboard
 *
 * @property viewModel is the viewModel for the bulletinboard
 * @property postViewModel is the viewModel for all posts
 * @property deleteBtn is the button used to delete a post
 */
class BulletinboardFragment : Fragment() {

    private lateinit var deleteBtn: ImageView
    private lateinit var adapter: PostAdapter
    private val loadingDialogFragment by lazy { LoadingFragment() }
    val postRepository: PostRepository by inject()
    private val postViewModel: PostViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory(PlaceType.Prikbord, postRepository)).get(
            PostViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<BulletinboardBinding>(
            inflater,
            R.layout.bulletinboard,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner


        deleteBtn = binding.include.deletePostsBtn

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        binding.BulletinBoardRecyclerPad?.layoutManager = staggeredGridLayoutManager

        binding.requestConsultationButton.setOnClickListener {
            this.context?.let { context ->
                MaterialAlertDialogBuilder(context)
                    .setTitle(R.string.aanvraag_gesprek_dialogbox)
                    .setMessage(R.string.aanvraag_gesprek_dialogbox_message)

                    .setPositiveButton("Ja") { dialog, which ->
                        // Respond to positive button press
                        postViewModel.requestConsultation()
                        this.view?.let { view ->
                            postViewModel.requestConsultationStatus.value?.let { string ->
                                Snackbar.make(view, string, Snackbar.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                    .setNegativeButton("Nee") { dialog, which ->
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

        binding.viewModel = postViewModel
        adapter = PostAdapter(
            object : CustomClick {
                override fun onClick(post: Post) {

                    postViewModel.deletePostByEmail(post.id, PlaceType.Prikbord)
                    true
                }
            }
        )

        binding.BulletinBoardRecycler?.adapter =
            adapter

        binding.BulletinBoardRecyclerPad?.adapter =
            adapter

        postViewModel.status.observe(
            this.viewLifecycleOwner,
            Observer {
                val contextView = this.view
                if (contextView != null) {
                    Snackbar.make(
                        contextView,
                        postViewModel.status.value.toString(),
                        Snackbar.LENGTH_SHORT
                    ).setAction(
                        R.string.tryAgain
                    ) {
                        postViewModel.postList
                    }.show()
                }
            }
        )

        binding.include.deletePostsBtn.setOnClickListener {
            try {
                this.context?.let { context ->
                    MaterialAlertDialogBuilder(context)
                        .setTitle("Alle posts verwijderen")
                        .setMessage("Bent u zeker dat u alle posts uit bulletinbord weg wilt?")

                        .setPositiveButton("Ja") { dialog, which ->
                            // Respond to positive button press
                            // postViewModel.deleteAllBulletinPosts();
                            this.view?.let { view ->
                                Snackbar.make(view, "Posts verwijdert", Snackbar.LENGTH_SHORT)
                                    .show()
                            }
                        }
                        .setNegativeButton("Nee") { dialog, which ->
                        }
                        .show()
                }
            } catch (e: Exception) {
                this.view?.let { view ->
                    Snackbar.make(view, e.message.toString(), Snackbar.LENGTH_SHORT).show()
                }
            }
        }

        postViewModel.postList.observe(
            this.viewLifecycleOwner,
            Observer
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
            }
        )

        postViewModel.status.observe(
            this.viewLifecycleOwner,
            Observer {
                val contextView = this.view
                if (contextView != null) {

                    Snackbar.make(
                        contextView,
                        "Er is niets om weer te geven",
                        Snackbar.LENGTH_SHORT
                    )
                        .setAction(
                            ""
                        ) {
                        }.show()
                }
            }
        )

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        deleteBtn.visibility = VISIBLE
    }

    override fun onStop() {
        super.onStop()
        deleteBtn.visibility = INVISIBLE
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
