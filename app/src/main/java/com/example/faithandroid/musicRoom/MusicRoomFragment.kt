package com.example.faithandroid.musicRoom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.PlaceType
import com.example.faithandroid.R
import com.example.faithandroid.ViewModelFactory
import com.example.faithandroid.databinding.MusicroomBinding
import com.example.faithandroid.post.PostViewModel
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse


class MusicRoomFragment: Fragment() {

    private val REQUEST_CODE = 1337
    private val REDIRECT_URI = "faithandroid://callback"
    private val CLIENT_ID = "95bc88d8f6084f1893dd648d88732210"

    private val musicRoomViewModel: MusicRoomViewModel by lazy{
        MusicRoomViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<MusicroomBinding>(
          inflater,
          R.layout.musicroom,
          container,
          false
      );
        binding.lifecycleOwner = this
        binding.viewModel = musicRoomViewModel
        binding.playlistRecycler.adapter = PlaylistAdapter()


        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.d("token", "wat start")

        val builder = AuthenticationRequest.Builder(
            CLIENT_ID,
            AuthenticationResponse.Type.TOKEN,
            REDIRECT_URI
        )

        builder.setScopes(arrayOf("streaming"))
        val request = builder.build()
        var intent = AuthenticationClient.createLoginActivityIntent(activity, request)
        startActivityForResult(intent, REQUEST_CODE)
        //AuthenticationClient.openLoginInBrowser(this.activity, request)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("token", "wat")

        if (requestCode === REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, data)
            Log.d("token", response.type.toString())
            when (response.type) {
                AuthenticationResponse.Type.TOKEN -> {
                    AppPreferences.spotifyToken = response.accessToken
                    Log.d("tokenSpotify", response.accessToken)
                    musicRoomViewModel.getUser()

                }
                AuthenticationResponse.Type.ERROR -> {
                    Log.d("tokenSpotify", response.error)
                }
                AuthenticationResponse.Type.EMPTY -> { Log.d("tokenSpotify", response.error + " empty")}
                AuthenticationResponse.Type.CODE -> { Log.d("tokenSpotify", response.error + " code")}
                AuthenticationResponse.Type.UNKNOWN -> { Log.d("tokenSpotify", response.error + " unknown")}
                else -> {
                    Log.d("tokenSpotify", "KUT")
                }
            }
        }
        else
        {
            Log.d("token", "wat")
        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}