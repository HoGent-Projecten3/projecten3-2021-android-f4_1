package com.example.faithandroid.post.video

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import com.example.faithandroid.*
import com.example.faithandroid.bulletinboard.BulletinboardFragmentDirections
import com.example.faithandroid.databinding.VideoToevoegenBinding
import com.google.android.material.textfield.TextInputLayout


class VideoToevoegenFragment: Fragment() {



    private val _videoGekozen = MutableLiveData<Boolean>(false)
    val videoGekozen: LiveData<Boolean>
        get() = _videoGekozen

    val PICK_IMAGE = 1
    val REQUEST_VIDEO_CAPTURE = 1

    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
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
//        binding.textPostToevoegen.setOnClickListener{ view: View ->
//
//            try
//            {
//                val post: Post = Post(0, binding.textposttitel.text.toString(), binding.textposttext.text.toString(), "testTime")
//
//                //viewModel.test.add(TextPost(binding.textposttitel.text.toString(), binding.textposttext.text.toString()))
//                when (args.placeType) {
//                    PlaceType.Prikbord -> {
//                        bulletinBoardViewModel.addNewPostToBulletinBoard(post)
//                        view.findNavController()
//                            .navigate(R.id.action_text_post_toevoegen_to_bulletinBoardFragment)
//                    }
//
//                    else -> { // Note the block
//                        Log.d("postError", "when mislukt")
//                    }
//                }
//            }
//            catch (e: Exception)
//            {
//                throw e
//            }
//        }
        viewModel = ViewModelProvider(this, ViewModelFactory(PlaceType.Prikbord)).get(PostViewModel::class.java)

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

            Log.d("itemmmm", id.toString() + placeTypes[position])


        }

        viewModel.getFilteredPostFromPlace(PlaceType.Prikbord, PostType.Video, "dora.theexplorer1999@gmail.com")

        return binding.root



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            Log.d("GELUKT", resultCode.toString())
            _videoGekozen.value = true;
            this.view?.findViewById<TextInputLayout>(R.id.titelVeld)?.visibility = View.VISIBLE


        }
        if (data != null) {
            data.toString()?.let { Log.d("NIET GELUKT", it) }
        }
    }




}