package com.example.faithandroid.musicRoom

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.*
import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.network.SpotifyApi
import com.example.faithandroid.network.SpotifyApiService
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await


class MusicRoomViewModel : ViewModel() {

    private val _allPlaylists = MutableLiveData<List<Playlist>>()
    val allPlaylists: LiveData<List<Playlist>>
        get() = _allPlaylists

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
        try {
            MainScope().launch {
                var call: Call<List<Playlist>> = FaithApi.retrofitService.getPlaylists()
                var list = call.await()
                    _playlists.value = list
    filterPlaylists()
            }
        }
        catch (e: Exception )
        {
            Log.d("error", e.localizedMessage)
        }
    }

    fun addPlaylist(playlist: Playlist)
    {
        try{
            MainScope().launch {
                var call = FaithApi.retrofitService.addPlaylist(playlist)
                call.enqueue(object : Callback<Void> {

                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful()) {
                            val responseString: String? = response.code().toString()
                            if (responseString != null) {
                                getPlaylists()

                            }
                        }
                    }

                    override fun onFailure(call: Call<Void>?, t: Throwable?) {
                        throw Exception("Er liep iets mis tijdens het toevoegen")
                    }
                })
            }

        }
        catch (e: java.lang.Exception)
        {
            Log.d("error", e.localizedMessage)
        }
    }

    fun deletePlaylist(primaryKey: Int)
    {
        try{
            MainScope().launch {
                var call = FaithApi.retrofitService.deletePlaylist(primaryKey)
                call.enqueue(object : Callback<Void> {

                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful()) {
                            val responseString: String? = response.code().toString()
                            if (responseString != null) {
                                getPlaylists()

                            }
                        }
                    }

                    override fun onFailure(call: Call<Void>?, t: Throwable?) {
                        throw Exception("Er liep iets mis tijdens het verwijderen")
                    }
                })
            }
        }
        catch (e: java.lang.Exception)
        {
            Log.d("error", e.localizedMessage)
        }
    }

    fun getAllPlaylists()
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
                _allPlaylists.value = list
                filterPlaylists()

            }
        }
        catch(e: Exception){
            Log.d("error", e.localizedMessage)
        }
    }

    private fun filterPlaylists()
    {
        _allPlaylists.value = allPlaylists.value?.filter { p -> playlists.value?.any { it.name == p.name } == false }
    }

}