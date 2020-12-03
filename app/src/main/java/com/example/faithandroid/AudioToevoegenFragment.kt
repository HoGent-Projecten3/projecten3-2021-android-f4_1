package com.example.faithandroid

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.database.Cursor
import android.media.MediaRecorder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.adapters.FilteredPostAdapter
import com.example.faithandroid.databinding.AudioToevoegenBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostViewModel
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.audio_toevoegen.*
import java.io.File
import java.io.IOException


class AudioToevoegenFragment: Fragment() {

    val args: AudioToevoegenFragmentArgs by navArgs()
    var post: Post? = null
    var nieuwePost: Boolean = false;

    private var path: String? = null
    private var myfile: String? = null
        lateinit var mr : MediaRecorder

    lateinit var output: String

    private var mediaRecorder: MediaRecorder? = null
    private var state: Boolean = false
    private var recordingStopped: Boolean = false
    lateinit var uitvoer: String

    var uri: Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       /* val path =
            Environment.getExternalStorageDirectory().absolutePath + "/storage/emulated/0/Android/media/"
        val dir = File(path)
        if (!dir.exists()) dir.mkdirs()
         myfile = path + "filename" + ".mp4"*/

        output = Environment.getExternalStorageDirectory().absolutePath + "/recording.mp3"
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

        binding.icVoice.setOnClickListener{
            start.isVisible = true
            stop.isVisible = true
            pauze.isVisible = true


        }

        val path = context?.filesDir?.absolutePath
        val file = File("$path/recording.mp3")
        Log.d("fileAzize",file.toString())



        binding.start.setOnClickListener{
            //eerst controleren of de gebruiker daadwerkelijk permissie heeft gegeven om audio op te nemen
           /* if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                val permissions = arrayOf(android.Manifest.permission.RECORD_AUDIO, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                ActivityCompat.requestPermissions(this, permissions,0)
            } else {

            }*/
            startRecording()

            binding.start.isEnabled = false
            binding.stop.isEnabled = true
            binding.pauze.isEnabled = true


        }
        binding.pauze.setOnClickListener{
            pauseRecording()

            binding.start.isEnabled = true
            binding.stop.isEnabled = true
            binding.pauze.isEnabled = false
        }

        binding.stop.setOnClickListener{
            stopRecording()

            binding.start.isEnabled = true
            binding.stop.isEnabled = false
            binding.pauze.isEnabled = false

            nieuwePost = true
            this.view?.findViewById<TextInputLayout>(R.id.titelVeld)?.visibility = View.VISIBLE


            val yourFilePath = requireContext().filesDir.toString() + "/" + "recording.mp3"
            val yourFile = File(yourFilePath)
            Log.d("yourfile","lijn172")


            val projection = arrayOf(
                MediaStore.Audio.AudioColumns.DATA,
                MediaStore.Audio.AudioColumns.TITLE
            )

            val c: Cursor? = requireContext().contentResolver.query(
                uri,
                projection,
                MediaStore.Audio.Media.DATA + " like ? ",
                arrayOf("%utm%"),
                null
            )

        }

        binding.recyclerView.adapter = FilteredPostAdapter(object : CustomClick {
            override fun onClick(post: Post) {
                this@AudioToevoegenFragment.post = post
                true
            }
        })

        binding.videoToevoegenButton.setOnClickListener {

            if(nieuwePost)
            {
                Log.d("AZIZA","if nieuwe post")
                post?.title = binding.titel.text.toString()
                post?.data = uitvoer

                Log.d("dataPost",post?.data.toString())

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
                        .navigate(R.id.action_audioToevoegenFragment_to_bulletinBoardFragment)
                }
                PlaceType.Schatkist -> {
                    it.findNavController()
                        .navigate(R.id.action_audioToevoegenFragment_to_treasureChestFragment)
                }
                PlaceType.Rugzak -> {
                    it.findNavController()
                        .navigate(R.id.action_audioToevoegenFragment_to_backpackFragment)
                }
            }
        }




        return binding.root
    }

    private fun startRecording() {
        try {
            Log.d("AziZEEE", "Start: ")
            mediaRecorder?.prepare()
            mediaRecorder?.start()
            state = true

            Toast.makeText(this.context, "Recording started!", Toast.LENGTH_SHORT).show()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun stopRecording(){
        if(state){
            mediaRecorder?.stop()
            //debuggen op release
            mediaRecorder?.release()
            state = false

        }else{
            Toast.makeText(this.context, "You are not recording right now!", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("RestrictedApi", "SetTextI18n")
    @TargetApi(Build.VERSION_CODES.N)
    private fun pauseRecording() {
        if(state) {
            if(!recordingStopped){
                Toast.makeText(this.context,"Stopped!", Toast.LENGTH_SHORT).show()
                mediaRecorder?.pause()
                recordingStopped = true
            }else{
                resumeRecording()
            }
        }
    }

    @SuppressLint("RestrictedApi", "SetTextI18n")
    @TargetApi(Build.VERSION_CODES.N)
    private fun resumeRecording() {
        Toast.makeText(this.context,"Resume!", Toast.LENGTH_SHORT).show()
        mediaRecorder?.resume()
        recordingStopped = false
    }

}