package com.example.faithandroid.post.video

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
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.PlaceType
import com.example.faithandroid.PostViewModel
import com.example.faithandroid.R
import com.example.faithandroid.databinding.VideoNieuweVideoPostBinding
import com.example.faithandroid.databinding.VideoToevoegenBinding

class NieuweVideoPost: Fragment() {

    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var binding = DataBindingUtil.inflate<VideoNieuweVideoPostBinding>(
            inflater,
            R.layout.video_nieuwe_video_post,
            container,
            false
        );

        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)




        return binding.root



    }

}