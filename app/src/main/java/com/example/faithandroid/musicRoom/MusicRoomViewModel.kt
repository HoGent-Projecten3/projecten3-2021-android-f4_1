package com.example.faithandroid.musicRoom

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.Playlist
import com.example.faithandroid.models.PlaylistWrapper
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.SpotifyUser
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
        getPlaylists()
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
                _playlists.value = list
                Log.d("spotifyUser", list[0].name)
            }
        }
        catch(e: Exception){
            Log.d("error", e.localizedMessage)
        }
    }


}