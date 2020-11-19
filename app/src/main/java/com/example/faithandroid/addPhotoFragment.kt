package com.example.faithandroid

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64.DEFAULT
import android.util.Base64.encodeToString
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.databinding.AddPhotoBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.treasureChest.TreasureChestPostAdapter
import java.io.ByteArrayOutputStream
import java.util.*


class addPhotoFragment: Fragment() {

    val args: addPhotoFragmentArgs by navArgs()

    val PICK_IMAGE = 1
    val REQUEST_PICTURE_CAPTURE = 1

    private lateinit var  viewModel: PostViewModel
    private lateinit var  dropdown : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<AddPhotoBinding>(
            inflater,
            R.layout.add_photo,
            container,
            false

        )
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, ViewModelFactory(args.placeType)).get(PostViewModel::class.java)

        binding.IconFolder.setOnClickListener { view: View ->

            val getIntent = Intent(Intent.ACTION_GET_CONTENT)
            getIntent.type = "image/*"

            val pickIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickIntent.type = "image/*"

            val chooserIntent = Intent.createChooser(getIntent, "Select Video")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(pickIntent))

            startActivityForResult(chooserIntent, PICK_IMAGE)

        }

        binding.iconPhoto.setOnClickListener{ view: View ->
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_PICTURE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                // display error state to the user
            }
        }

        val placeTypes =  PlaceType.values()

        val adapter = this.context?.let {
            ArrayAdapter<PlaceType>(
                it,
                R.layout.dropdown_menu_popup_item_extra,
                PlaceType.values()
            )
        }


        //val editTextFilledExposedDropdown: AutoCompleteTextView? = this.view?.findViewById(R.id.filled_exposed_dropdown)
        binding.dropdownPlaatsen.setAdapter(adapter)
        binding.dropdownPlaatsen.setText(PlaceType.Rugzak.name, false)

        binding.dropdownPlaatsen.setOnItemClickListener { parent, view, position, id ->
            viewModel.getFilteredPostFromPlace(
                placeTypes[position],
                PostType.Image,
                "dora.theexplorer1999@gmail.com"
            )
        }


        viewModel.getFilteredPostFromPlace(
            PlaceType.Rugzak,
            PostType.Image,
            "dora.theexplorer1999@gmail.com"
        )
        binding.viewModel = viewModel
        binding.addImageRecyclerView.adapter = TreasureChestPostAdapter()


        return binding.root
    }

    fun getBytesFromBitmap(bitmap: Bitmap): ByteArray? {
        val stream = ByteArrayOutputStream()
        bitmap.compress(CompressFormat.JPEG, 70, stream)
        return stream.toByteArray()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_PICTURE_CAPTURE && resultCode == RESULT_OK) {
            Log.d("dad",data.toString())
            val bitImage = data?.extras?.get("data") as Bitmap
            val byteImage = getBytesFromBitmap(bitImage)

            val stringImage = Base64.getEncoder().encodeToString(byteImage)
            val post = Post(
                0,
                "foto van hond",
                "fotoVanHond.jpg",
                "2020-11-19T21:19:39.362Z",
                PostType.Image.ordinal,
                stringImage,
                ""
            )
            viewModel.addPostByEmail(post, args.placeType, "dora.theexplorer1999@gmail.com")
            post.dataBytes?.let { Log.d("fo", it) }
        }
    }
}