package com.example.faithandroid.musicRoom

import AppPreferences
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import com.example.faithandroid.CustomPlaylistClick
import com.example.faithandroid.LoadingFragment
import com.example.faithandroid.R
import com.example.faithandroid.databinding.MusicroomBinding
import com.example.faithandroid.models.Playlist
import com.example.faithandroid.util.Status
import com.google.android.material.snackbar.Snackbar
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import kotlinx.android.synthetic.main.app_bar_musicroom.view.*
import org.koin.android.ext.android.inject

/**
 * Fragment for the Music Room
 *
 * @property spotifyAppRemoteLocal is used to open Spotify when clicking on a playlist
 * @property musicRoomViewModel is the viewModel for the music room
 */
class MusicRoomFragment : Fragment() {
    private val REQUEST_CODE = 1337
    private val REDIRECT_URI = "faithandroid://callback"
    private val CLIENT_ID = "95bc88d8f6084f1893dd648d88732210"
    private var spotifyAppRemoteLocal: SpotifyAppRemote? = null
    private val loadingDialogFragment by lazy { LoadingFragment() }
    private lateinit var adapter: PlaylistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val musicRoomViewModel: MusicRoomViewModel by inject()
        val binding = DataBindingUtil.inflate<MusicroomBinding>(
            inflater,
            R.layout.musicroom,
            container,
            false
        )

        binding.lifecycleOwner = this
        binding.viewModel = musicRoomViewModel
        musicRoomViewModel.getAllPlaylists()
        val contextView = this.view
        this.adapter = PlaylistAdapter(
            object : CustomPlaylistClick {
                override fun onClick(playlist: Playlist): Boolean {
                    if (spotifyAppRemoteLocal != null) {
                        if (spotifyAppRemoteLocal!!.isConnected) {
                            val intent = Intent(Intent.ACTION_VIEW)
                            intent.data = Uri.parse("spotify:playlist:${playlist.id}")
                            intent.putExtra(
                                Intent.EXTRA_REFERRER,
                                Uri.parse("android-app://" + this@MusicRoomFragment.context?.packageName)
                            )
                            startActivity(intent)
                            return true
                        } else {
                            return false
                        }
                    } else {

                        return false
                    }
                }
            },
            object : CustomPlaylistClick {
                override fun onClick(playlist: Playlist): Boolean {
                    musicRoomViewModel.deletePlaylist(playlist.primaryKey)
                    return true
                }
            }
        )
        binding.playlistRecycler.adapter = adapter

        binding.include4.newPlaylistButton.setOnClickListener {
            Log.d("WTF", "WTF")
            val popup = PopupMenu(context, it)

            musicRoomViewModel.allPlaylists.value?.forEach {
                popup.menu.add(it.name)
            }
            popup.setOnMenuItemClickListener {

                var playlist =
                    musicRoomViewModel.allPlaylists.value?.find { playlist: Playlist ->
                        playlist.name == it.title
                    }

                if (playlist != null) {
                    musicRoomViewModel.addPlaylist(playlist)
                }

                true
            }

            popup.show()
        }

        this.lifecycle.addObserver(
            object : LifecycleObserver {
            }
        )

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val contextView = this.view
        val connectionParams = ConnectionParams.Builder(CLIENT_ID)
            .setRedirectUri(REDIRECT_URI)
            .showAuthView(true)
            .build()
        if (SpotifyAppRemote.isSpotifyInstalled(this.context)) {
            SpotifyAppRemote.connect(
                this.context,
                connectionParams,
                object : Connector.ConnectionListener {
                    override fun onConnected(spotifyAppRemote: SpotifyAppRemote) {
                        spotifyAppRemoteLocal = spotifyAppRemote
                    }

                    override fun onFailure(throwable: Throwable) {


                        Snackbar.make(
                            contextView!!,
                            "Er liep iets mis bij het inloggen",
                            Snackbar.LENGTH_SHORT
                        )
                            .setAction(
                                "Try again"
                            ) {
                                onStart()
                            }.show()
                    }
                }
            )
        }

        val builder = AuthenticationRequest.Builder(
            CLIENT_ID,
            AuthenticationResponse.Type.TOKEN,
            REDIRECT_URI
        )

        builder.setScopes(arrayOf("streaming"))
        val request = builder.build()
        var intent = AuthenticationClient.createLoginActivityIntent(activity, request)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onStop() {
        super.onStop()
        if (spotifyAppRemoteLocal != null) {
            SpotifyAppRemote.disconnect(spotifyAppRemoteLocal)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val musicRoomViewModel: MusicRoomViewModel by inject()
        if (requestCode === REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, data)
            if (response.type == AuthenticationResponse.Type.TOKEN) {
                AppPreferences.spotifyToken = response.accessToken
                musicRoomViewModel.getAllPlaylists()
//                musicRoomViewModel.allPlaylists.observe(
//                    viewLifecycleOwner,
//                    Observer {
//                        it?.let { resource ->
//                            when (resource.status) {
//                                Status.SUCCESS -> {
//                                    showProgress(false)
//                                    adapter.submitList(resource.data)
//                                }
//                                Status.LOADING -> {
//                                    showProgress(true)
//                                }
//                                Status.ERROR -> {
//                                    showProgress(false)
//                                }
//                            }
//                        }
//                    }
//                )
            } else {
                val contextView = this.view
                if (contextView != null) {

                    Snackbar.make(
                        contextView,
                        "U bent niet ingelogd bij spotify",
                        Snackbar.LENGTH_SHORT
                    )
                        .setAction(
                            ""
                        ) {
                        }.show()
                }
            }
        }
    }

    private fun showProgress(b: Boolean) {
        if (b) {
            if (!loadingDialogFragment.isAdded) {
                loadingDialogFragment.show(requireActivity().supportFragmentManager, "loader")
            }
        } else {
            if (loadingDialogFragment.isAdded) {
                loadingDialogFragment.dismissAllowingStateLoss()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
