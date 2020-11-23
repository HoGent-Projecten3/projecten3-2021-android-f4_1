package com.example.faithandroid.post.video

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.*
import com.example.faithandroid.databinding.VideoToevoegenBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.PostAdapter
import com.example.faithandroid.databinding.ListdataPostBinding
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.skyscraper_goalpostimage.view.*
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.*


class VideoToevoegenFragment: Fragment() {

    val args: VideoToevoegenFragmentArgs by navArgs()

    var post: Post? = null

    var nieuwePost: Boolean = false;

    private val _videoGekozen = MutableLiveData<Boolean>(false)
    val videoGekozen: LiveData<Boolean>
        get() = _videoGekozen

    val PICK_IMAGE = 1
    val REQUEST_VIDEO_CAPTURE = 1

    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var binding = DataBindingUtil.inflate<VideoToevoegenBinding>(
            inflater,
            R.layout.video_toevoegen,
            container,
            false
        );


        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, ViewModelFactory(args.placeType)).get(PostViewModel::class.java)

        binding.album.setOnClickListener{ view: View ->
            val getIntent = Intent(Intent.ACTION_GET_CONTENT)
            getIntent.type = "video/*"

            val pickIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickIntent.type = "video/*"

            val chooserIntent = Intent.createChooser(getIntent, "Select Video")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(pickIntent))

            startActivityForResult(chooserIntent, PICK_IMAGE)
        }

        binding.videocam.setOnClickListener{ view: View ->
                val takePictureIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
                try {
                    startActivityForResult(takePictureIntent, REQUEST_VIDEO_CAPTURE)
                } catch (e: ActivityNotFoundException) {
                    // display error state to the user
                }
            }




        val placeTypes =  PlaceType.values()

        val adapter = this.context?.let {
            ArrayAdapter<PlaceType>(
                it,
                R.layout.dropdown_menu_popup_item,
                PlaceType.values()
            )
        }

        //val editTextFilledExposedDropdown: AutoCompleteTextView? = this.view?.findViewById(R.id.filled_exposed_dropdown)
        binding.filledExposedDropdown.setAdapter(adapter)
        binding.filledExposedDropdown.setText(PlaceType.Rugzak.name, false)

        binding.filledExposedDropdown.setOnItemClickListener { parent, view, position, id ->
            viewModel.getFilteredPostFromPlace(
                placeTypes[position],
                PostType.Video,
                "dora.theexplorer1999@gmail.com"
            )
        }


        viewModel.getFilteredPostFromPlace(
            PlaceType.Rugzak,
            PostType.Video,
            "dora.theexplorer1999@gmail.com"
        )
        binding.viewModel = viewModel
        binding.recyclerView.adapter = PostAdapter(object : CustomLongClick {
            override fun onClick(post: Post) {
                this@VideoToevoegenFragment.post = post
                true
            }
        })




        binding.videoToevoegenButton.setOnClickListener{

            if(nieuwePost)
            {
                post?.title = binding.titel.text.toString()
                post?.data = binding.titel.text?.replace("\\s".toRegex(), "").toString()

                post?.let { it1 -> viewModel.addPostByEmail(
                    it1,
                    args.placeType,
                    "dora.theexplorer1999@gmail.com"
                ) }
            }
            else
            {
                if(post != null)
                {
                    viewModel.addExistingPostToPlace(post!!.id, args.placeType)
                }
            }


            when(args.placeType)
            {
                PlaceType.Prikbord -> {
                    it.findNavController()
                        .navigate(R.id.action_videoToevoegenFragment_to_bulletinBoardFragment)
                }
            }

        }

        return binding.root



    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {

            _videoGekozen.value = true;
           val videoString = data?.data?.let { uriToBase64(it) }

            this.post = Post(
                0,
                "video",
                "video.mp4",
                "2020-11-19T21:19:39.362Z",
                PostType.Video.ordinal,
                videoString,
                "")

            nieuwePost = true
        }
        if (data != null) {
            this.view?.findViewById<TextInputLayout>(R.id.titelVeld)?.visibility = View.VISIBLE
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun uriToBase64(uri: Uri): String
    {
        val inputStream: InputStream? =
            getActivity()?.getContentResolver()?.openInputStream(uri)

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