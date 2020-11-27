package com.example.faithandroid

import android.Manifest
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.os.Environment
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
import com.example.faithandroid.databinding.AudioToevoegenBinding
import com.example.faithandroid.models.Post
import kotlinx.android.synthetic.main.audio_toevoegen.*
import java.io.IOException

class AudioToevoegenFragment: Fragment() {

    val args: AudioToevoegenFragmentArgs by navArgs()
    var post: Post? = null
    var nieuwePost: Boolean = false;


    private var output: String? = null
    private var mediaRecorder: MediaRecorder? = null
    private var state: Boolean = false
    private var recordingStopped: Boolean = false

    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        output = Environment.getExternalStorageDirectory().absolutePath + "/audios.mp3"
        mediaRecorder = MediaRecorder()

        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        mediaRecorder?.setOutputFile(output)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

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
            startRecording()
        }
        binding.pauze.setOnClickListener{
            pauseRecording()
        }

        binding.stop.setOnClickListener{
            stopRecording()
        }
        binding.recyclerView.adapter = FilteredPostAdapter(object : CustomClick {
            override fun onClick(post: Post) {
                this@AudioToevoegenFragment.post = post
                true
            }
        })
        return binding.root
    }
    private fun startRecording() {
        try {
            mediaRecorder?.prepare()
            mediaRecorder?.start()
            state = true
          //  Toast.makeText(this, "Recording started!", Toast.LENGTH_SHORT).show()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun stopRecording(){
        if(state){
            mediaRecorder?.stop()
            mediaRecorder?.release()
            state = false
        }else{
           // Toast.makeText(this, "You are not recording right now!", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("RestrictedApi", "SetTextI18n")
    @TargetApi(Build.VERSION_CODES.N)
    private fun pauseRecording() {
        if(state) {
            if(!recordingStopped){
               // Toast.makeText(this,"Stopped!", Toast.LENGTH_SHORT).show()
                mediaRecorder?.pause()
                recordingStopped = true
                pauze.text = "Resume"
            }else{
                resumeRecording()
            }
        }
    }

    @SuppressLint("RestrictedApi", "SetTextI18n")
    @TargetApi(Build.VERSION_CODES.N)
    private fun resumeRecording() {
       // Toast.makeText(this,"Resume!", Toast.LENGTH_SHORT).show()
        mediaRecorder?.resume()
        pauze.text = "Pause"
        recordingStopped = false
    }
}