package com.example.faithandroid.post.photo

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.*
import com.example.faithandroid.adapters.FilteredPostAdapter
import com.example.faithandroid.databinding.AddPhotoBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.post.PostViewModel
import com.google.android.material.textfield.TextInputLayout
import org.koin.android.ext.android.inject
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.*

class AddPhotoFragment : Fragment() {

    val args: AddPhotoFragmentArgs by navArgs()

    var post: Post? = null

    var nieuwePost: Boolean = false

    val PICK_IMAGE = 1
    val REQUEST_PICTURE_CAPTURE = 2

    private lateinit var viewModel: PostViewModel
    private lateinit var dropdown: Spinner
    val postRepository: PostRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<AddPhotoBinding>(
            inflater,
            R.layout.add_photo,
            container,
            false

        )
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, ViewModelFactory(args.placeType, postRepository)).get(PostViewModel::class.java)

        binding.IconFolder.setOnClickListener { view: View ->

            val getIntent = Intent(Intent.ACTION_GET_CONTENT)
            getIntent.type = "image/*"

            val pickIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickIntent.type = "image/*"

            val chooserIntent = Intent.createChooser(getIntent, "Select Image")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(pickIntent))

            startActivityForResult(chooserIntent, PICK_IMAGE)
        }

        binding.iconPhoto.setOnClickListener { view: View ->
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_PICTURE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                // display error state to the user
            }
        }

        val placeTypes = PlaceType.values()

        val adapter = this.context?.let {
            var plac = PlaceType.values().toList()
            var index = plac.indexOf(args.placeType)

            ArrayAdapter<PlaceType>(
                it,
                R.layout.dropdown_menu_popup_item_extra,
                plac
            )
        }

        // val editTextFilledExposedDropdown: AutoCompleteTextView? = this.view?.findViewById(R.id.filled_exposed_dropdown)
        binding.dropdownPlaatsen.setAdapter(adapter)
        binding.dropdownPlaatsen.setText(PlaceType.Rugzak.name, false)

        binding.dropdownPlaatsen.setOnItemClickListener { parent, view, position, id ->
            viewModel.getFilteredPostFromPlace(
                placeTypes[position],
                PostType.Image
            )
        }
        viewModel.getFilteredPostFromPlace(
            PlaceType.Rugzak,
            PostType.Image
        )
        binding.viewModel = viewModel

        binding.addImageRecyclerView.adapter = FilteredPostAdapter(
            object : CustomClick {
                override fun onClick(post: Post) {
                    this@AddPhotoFragment.post = post
                    true
                }
            }
        )

        binding.fotoToevoegenButton.setOnClickListener {

            if (nieuwePost) {
                post?.title = binding.titelImage.text.toString()
                post?.data = binding.titelImage.text?.replace("\\s".toRegex(), "").toString()
                post?.let { it1 ->

                    viewModel.addPostByEmail(
                        it1,
                        args.placeType
                    )
                }
            } else {
                if (post != null) {
                    viewModel.addExistingPostToPlace(post!!.id, args.placeType)
                }
            }
            when (args.placeType) {
                PlaceType.Prikbord -> {
                    it.findNavController()
                        .navigate(R.id.action_addPhotoFragment_to_bulletinBoardFragment)
                }
                PlaceType.Schatkist -> {
                    it.findNavController()
                        .navigate(R.id.action_addPhotoFragment_to_treasureChestFragment)
                }
                PlaceType.Rugzak -> {
                    it.findNavController()
                        .navigate(R.id.action_addPhotoFragment_to_backpackFragment)
                }
            }
        }
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_PICTURE_CAPTURE && resultCode == RESULT_OK) {

            var imageString: String?
            if (data?.data == null) {
                val imageBitmap = data?.extras?.get("data") as Bitmap
                val stream = ByteArrayOutputStream()
                imageBitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
                val image = stream.toByteArray()
                imageString = Base64.getEncoder().encodeToString(image)
            } else {
                imageString = data?.data?.let { uriToBase64(it) }
            }
            this.post = Post(
                0,
                "foto van hond",
                "fotoVanHond.jpg",
                "2020-11-19T21:19:39.362Z",
                PostType.Image.ordinal,
                imageString,
                "",
                backpack = false,
                bulletinBoard = false,
                treasureChest = false,
            )
            nieuwePost = true
        }
        if (data != null) {
            this.view?.findViewById<TextInputLayout>(R.id.titleFieldImage)?.visibility = View.VISIBLE
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun uriToBase64(uri: Uri): String {
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
        } != -1
        ) {
            byteBuffer.write(buffer, 0, len)
        }
        val arr = byteBuffer.toByteArray()

        val image: String = Base64.getEncoder().encodeToString(arr)

        return image
    }
}
