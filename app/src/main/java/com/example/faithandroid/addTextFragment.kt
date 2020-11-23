package com.example.faithandroid

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
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
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.databinding.AddPhotoBinding
import com.example.faithandroid.databinding.AddTextBinding
import com.example.faithandroid.models.Post
import com.google.android.material.textfield.TextInputLayout

class addTextFragment: Fragment() {


    val args: addTextFragmentArgs by navArgs()

    var post: Post? = null

    private lateinit var  viewModel: PostViewModel

    private lateinit var  dropdown : Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<AddTextBinding>(
            inflater,
            R.layout.add_text,
            container,
            false,

        )
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, ViewModelFactory(args.placeType)).get(PostViewModel::class.java)

        binding.imageView4.setOnClickListener{
                view: View ->  val action =
            addTextFragmentDirections.actionAddTextFragmentToTextPostToevoegen(
                args.placeType
            )
            view.findNavController().navigate(action)
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
        binding.filledExposedDropdown.setAdapter(adapter)
        binding.filledExposedDropdown.setText(PlaceType.Rugzak.name, false)

        binding.filledExposedDropdown.setOnItemClickListener { parent, view, position, id ->
            viewModel.getFilteredPostFromPlace(
                placeTypes[position],
                PostType.Text,
                "dora.theexplorer1999@gmail.com"
            )
        }


        viewModel.getFilteredPostFromPlace(
            PlaceType.Rugzak,
            PostType.Text,
            "dora.theexplorer1999@gmail.com"
        )
        binding.viewModel = viewModel
        binding.recyclerView.adapter =
            PostAdapter()



        binding.textToevoegenButton.setOnClickListener{

            Log.d("po",post?.data.toString())
            post?.let { it1 -> viewModel.addPostByEmail(
                it1,
                args.placeType,
                "dora.theexplorer1999@gmail.com"
            ) }
            when(args.placeType)
            {
                PlaceType.Prikbord -> {
                    it.findNavController()
                        .navigate(R.id.action_addTextFragment_to_bulletinBoardFragment)
                }
            }
        }

        return binding.root

    }
}