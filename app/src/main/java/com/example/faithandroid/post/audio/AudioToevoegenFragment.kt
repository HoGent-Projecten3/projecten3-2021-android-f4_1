package com.example.faithandroid.post.audio

import android.app.Activity
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
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.*
import com.example.faithandroid.databinding.AudioToevoegenBinding
import com.example.faithandroid.models.Post
import com.google.android.material.textfield.TextInputLayout
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.*



class AudioToevoegenFragment: Fragment() {

    val args: AudioToevoegenFragmentArgs by navArgs()

    var post: Post? = null

    var nieuwePost: Boolean = false;

    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        var binding = DataBindingUtil.inflate<AudioToevoegenBinding>(
            inflater,
            R.layout.audio_toevoegen,
            container,
            false
        );

        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, ViewModelFactory(args.placeType)).get(PostViewModel::class.java)


        binding.start

        return binding.root;
    }
}