package com.example.faithandroid.post.audio

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Intent
import android.media.MediaRecorder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.*
import com.example.faithandroid.adapters.FilteredPostAdapter
import com.example.faithandroid.databinding.AudioToevoegenBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.audio_toevoegen.*
import java.io.*
import java.util.*


class AddAudioFragment: Fragment() {

    val args: AddAudioFragmentArgs by navArgs()
    var post: Post? = null
    var nieuwePost: Boolean = false;
    lateinit var output: String
    private var mediaRecorder: MediaRecorder? = null
    private var state: Boolean = false
    private var recordingStopped: Boolean = false
    var audioPost : String =""
    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        output = Environment.getExternalStorageDirectory().absolutePath + "/Alarms/recording.mp3"
        mediaRecorder = MediaRecorder()

        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        mediaRecorder?.setOutputFile(output)

    }

    @RequiresApi(Build.VERSION_CODES.O)
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
            ViewModelProvider(this,
                ViewModelFactory(args.placeType)
            ).get(PostViewModel::class.java)

        viewModel.status.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            Snackbar.make(contextView!!, viewModel.status.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                ""
            )
            {
            }.show()
        })

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
                PostType.Audio
            )
        }

        viewModel.getFilteredPostFromPlace(
            PlaceType.Rugzak,
            PostType.Audio
        )



        binding.viewModel = viewModel

        binding.icVoice.setOnClickListener{
            start.isVisible = true
            stop.isVisible = true
            pauze.isVisible = true
        }

        binding.start.setOnClickListener{
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

        }

        binding.recyclerView.adapter = FilteredPostAdapter(object :CustomClick {
            override fun onClick(post: Post) {
                this@AddAudioFragment.post = post
                true
            }
        })


        binding.audioToevoegenButton.setOnClickListener {



            if(nieuwePost)
            {
                this.post = Post(
                    0,
                    "audio",
                    "recording.mp3",
                    "2020-11-19T21:19:39.362Z",
                    PostType.Audio.ordinal,
                    audioPost,
                    ""
                )

                post?.title = binding.titel.text.toString()
                post?.dataBytes = audioPost

                post?.let { it1 -> viewModel.addPostByEmail(
                    it1,
                    args.placeType
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

    @RequiresApi(Build.VERSION_CODES.O)
    private fun stopRecording(){
        if(state){
            mediaRecorder?.stop()
            mediaRecorder?.release()
            state = false

            audioPost =  uriToBase64(Uri.parse("file://$output"))

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

    @RequiresApi(Build.VERSION_CODES.O)
    private fun uriToBase64(uri: Uri): String
    {
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
            } != -1) {
            byteBuffer.write(buffer, 0, len)
        }
        val arr = byteBuffer.toByteArray()

        val audio: String = Base64.getEncoder().encodeToString(arr)
        return audio

    }
}
