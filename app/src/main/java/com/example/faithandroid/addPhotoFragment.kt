package com.example.faithandroid

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.faithandroid.databinding.AddPhotoBinding


class addPhotoFragment: Fragment() {

    val PICK_IMAGE = 1
    val REQUEST_PICTURE_CAPTURE = 1


    private  lateinit var  dropdown : Spinner

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




        }

        return binding.root
    }
}