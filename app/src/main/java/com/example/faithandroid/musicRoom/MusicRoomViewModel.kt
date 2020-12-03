package com.example.faithandroid.musicRoom

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.*
import com.example.faithandroid.network.SpotifyApi
import com.example.faithandroid.network.SpotifyApiService
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.await


class MusicRoomViewModel : ViewModel() {

    private val _playlists = MutableLiveData<List<Playlist>>()
    val playlists: LiveData<List<Playlist>>
        get() = _playlists


    init
    {
    }


    fun getUser()
    {
        try{
            MainScope().launch {
                var call: Call<SpotifyUser> = SpotifyApi.retrofitService.getUser()
                var user: SpotifyUser = call.await()
                Log.d("spotifyUser", user.id)
            }

        }
        catch(e: Exception){
            Log.d("error", e.localizedMessage)
        }
    }

    fun getPlaylists()
    {
        try
        {
            MainScope().launch {
                var call: Call<PlaylistWrapper> = SpotifyApi.retrofitService.getPlaylists()
                var list: List<Playlist> = call.await().items
                list.forEach { p ->
                    var call: Call<List<SpotifyCover>> = SpotifyApi.retrofitService.getPlaylistCover(p.id)
                    var coverList = call.await()
                    p.url = coverList[0].url
                }
                _playlists.value = list

            }
        }
        catch(e: Exception){
            Log.d("error", e.localizedMessage)
        }
    }

    fun getPlaylistCovers()
    {
        try {
            MainScope().launch {

            }
        }
        catch(e: Exception)
        {
            Log.d("error", e.localizedMessage)
        }

    }


}