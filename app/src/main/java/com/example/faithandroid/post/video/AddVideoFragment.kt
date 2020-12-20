package com.example.faithandroid.post.video

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.*
import com.example.faithandroid.adapters.FilteredPostAdapter
import com.example.faithandroid.databinding.AddVideoBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.post.PostViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import org.koin.android.ext.android.inject
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.*

/**
 * This is a fragment for adding video
 */
class AddVideoFragment : Fragment() {

    /**
     * @param args -------------????--------------
     * @param post is the post to be added
     * @param nieuwePost keeps track of whether the post is newly added to the app or transferred from another place within the app
     * @param PICK_IMAGE --------------????-------------
     * @param REQUEST_VIDEO_CAPTURE ------------????-----------
     * @param viewModel is the viewmodel for all posts
     */
    val args: AddVideoFragmentArgs by navArgs()

    var post: Post? = null

    var nieuwePost: Boolean = false
    val postRepository: PostRepository by inject()

    val PICK_IMAGE = 1
    val REQUEST_VIDEO_CAPTURE = 2

    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = DataBindingUtil.inflate<AddVideoBinding>(
            inflater,
            R.layout.add_video,
            container,
            false
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

        binding.album.setOnClickListener { view: View ->
            val getIntent = Intent(Intent.ACTION_GET_CONTENT)
            getIntent.type = "video/*"

            val pickIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickIntent.type = "video/*"

            val chooserIntent = Intent.createChooser(getIntent, "Select Video")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(pickIntent))

            startActivityForResult(chooserIntent, PICK_IMAGE)
        }

        binding.videocam.setOnClickListener { view: View ->
                val takePictureIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
                try {
                    startActivityForResult(takePictureIntent, REQUEST_VIDEO_CAPTURE)
                } catch (e: ActivityNotFoundException) {
                }
            }

        val placeTypes = PlaceType.values()

        val adapter = this.context?.let {
            ArrayAdapter<PlaceType>(
                it,
                R.layout.dropdown_menu_popup_item,
                PlaceType.values()
            )
        }

        binding.filledExposedDropdown.setAdapter(adapter)
        binding.filledExposedDropdown.setText(PlaceType.Rugzak.name, false)
        binding.filledExposedDropdown.setOnItemClickListener { parent, view, position, id ->
            viewModel.getFilteredPostFromPlace(
                placeTypes[position],
                PostType.Video
            )
        }

        viewModel.getFilteredPostFromPlace(
            PlaceType.Rugzak,
            PostType.Video
        )
        binding.viewModel = viewModel

        binding.recyclerView.adapter = FilteredPostAdapter(
            object : CustomClick {
override fun onClick(post: Post) {
this@AddVideoFragment.post = post
true
}
}
        )

       binding.videoToevoegenButton.setOnClickListener {
            if (nieuwePost) {
                post?.title = binding.titel.text.toString()
                post?.data = binding.titel.text?.replace("\\s".toRegex(), "").toString()
                post?.let { it1 -> viewModel.addPostByEmail(
                    it1,
                    args.placeType
                ) }
            } else {
                if (post != null) {
                    viewModel.addExistingPostToPlace(post!!.id, args.placeType)
                } else {
                    viewModel.status = MutableLiveData("Er liep iets mis met een bestaande post toevoegen")
                }
            }
            when (args.placeType) {
                PlaceType.Prikbord -> {
                    it.findNavController()
                        .navigate(R.id.action_videoToevoegenFragment_to_bulletinBoardFragment)
                }
                PlaceType.Schatkist -> {
                    it.findNavController()
                        .navigate(R.id.action_videoToevoegenFragment_to_treasureChestFragment)
                }
                PlaceType.Rugzak -> {
                    it.findNavController()
                        .navigate(R.id.action_videoToevoegenFragment_to_backpackFragment)
                }
            }
        }

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
           val videoString = data?.data?.let { uriToBase64(it) }
            this.post = Post(
                0,
                "video",
                "video.mp4",
                "2020-11-19T21:19:39.362Z",
                PostType.Video.ordinal,
                videoString,
                "",
                backpack = false,
                bulletinBoard = false,
                treasureChest = false
            )
            nieuwePost = true
        }
        if (data != null) {
            this.view?.findViewById<TextInputLayout>(R.id.titelVeld)?.visibility = View.VISIBLE
        }
    }

    /**
     * converts a uri to base64
     *
     * @param uri is the uri to be converted
     */
    @RequiresApi(Build.VERSION_CODES.O)
    private fun uriToBase64(uri: Uri): String {
        val inputStream: InputStream? = getActivity()?.getContentResolver()?.openInputStream(uri)
        val byteBuffer = ByteArrayOutputStream()
        val bufferSize = 1024
        val buffer = ByteArray(bufferSize)
        var len = 0
        while (inputStream?.read(buffer).also {
                if (it != null) {
                    len = it
                }
            } != -1) {
            byteBuffer.write(buffer, 0, len)
        }
        val arr = byteBuffer.toByteArray()
        val image: String = Base64.getEncoder().encodeToString(arr)
        return image
    }
}
