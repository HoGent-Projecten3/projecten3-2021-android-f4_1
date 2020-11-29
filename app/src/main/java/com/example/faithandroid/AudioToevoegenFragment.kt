package com.example.faithandroid

import android.Manifest
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.adapters.FilteredPostAdapter
import com.example.faithandroid.databinding.AudioToevoegenBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostViewModel
import kotlinx.android.synthetic.main.audio_toevoegen.*
import java.io.IOException
class AudioToevoegenFragment: Fragment() {

    val args: AudioToevoegenFragmentArgs by navArgs()
    var post: Post? = null
    var nieuwePost: Boolean = false;

    private var path: String? = null
    lateinit var mr : MediaRecorder


    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mr = MediaRecorder()

        var path = Environment.getExternalStorageDirectory().toString() + "/audios.mp3"

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = DataBindingUtil.inflate<AudioToevoegenBinding>(
            inflater,
            R.layout.audio_toevoegen,
            container,
            false
        );

        binding.lifecycleOwner = this

        viewModel =
            ViewModelProvider(this, ViewModelFactory(args.placeType)).get(PostViewModel::class.java)


        val placeTypes = PlaceType.values()

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
                PostType.Audio,
                "dora.theexplorer1999@gmail.com"
            )
        }


        viewModel.getFilteredPostFromPlace(
            PlaceType.Rugzak,
            PostType.Audio,
            "dora.theexplorer1999@gmail.com"
        )
        binding.viewModel = viewModel



        binding.start.setOnClickListener{
            //eerst controleren of de gebruiker daadwerkelijk permissie heeft gegeven om audio op te nemen
           /* if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                val permissions = arrayOf(android.Manifest.permission.RECORD_AUDIO, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                ActivityCompat.requestPermissions(this, permissions,0)
            } else {
                startRecording()
            }*/
            mr.setAudioSource(MediaRecorder.AudioSource.MIC)
            mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            mr.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
            mr.setOutputFile(path)
            mr.prepare()
            mr.start()

            binding.stop.isEnabled = true
            binding.start.isEnabled = false
        }
        binding.beluister.setOnClickListener{
            var mp = MediaPlayer()
            mp.setDataSource(path)
            mp.prepare()
            mp.start()
        }

        binding.stop.setOnClickListener{

            mr.stop()
            binding.start.isEnabled = true
            binding.stop.isEnabled = false
            binding.beluister.isEnabled = true
        }



        binding.recyclerView.adapter = FilteredPostAdapter(object : CustomClick {
            override fun onClick(post: Post) {
                this@AudioToevoegenFragment.post = post
                true
            }
        })
        return binding.root
    }

}