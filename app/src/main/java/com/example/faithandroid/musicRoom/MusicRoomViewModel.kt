package com.example.faithandroid.musicRoom

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.faithandroid.models.*
<<<<<<< HEAD
=======
import com.example.faithandroid.network.SpotifyApi
>>>>>>> 18cbca2 (repository goalposts werkt)
import com.example.faithandroid.network.SpotifyApiService
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await

import com.example.faithandroid.models.Post
import com.example.faithandroid.util.Resource


class MusicRoomViewModel(private val spotifyRepository : SpotifyRepository) : ViewModel() {

    var allPlaylists: LiveData<Resource<List<Playlist>>> = spotifyRepository.getPlaylistsSpotify()


    var playlists: LiveData<Resource<List<Playlist>>> = spotifyRepository.getPlaylistsFaith()

    init
    {
        filterPlaylists()
    }



    /*fun getPlayRemotelists()
    {
        /*try {
            MainScope().launch {
                var call: Call<List<Playlist>> = spotifyRepository.getPlaylistsFaith()
                var list = call.await()
                    playlists.value.data = list
    filterPlaylists()
            }
        }
        catch (e: Exception )
        {
<<<<<<< HEAD
        }
    }*/
=======
        }*/
    }
>>>>>>> 18cbca2 (repository goalposts werkt)

    fun addPlaylist(playlist: Playlist)
    {
        /*try{
            MainScope().launch {
                var call = spotifyRepository.addPlaylist(playlist)
                call.enqueue(object : Callback<Void> {

                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful()) {
                            val responseString: String? = response.code().toString()
                            if (responseString != null) {
                                //getPlayRemotelists()

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
        }*/
    }

    fun deletePlaylist(primaryKey: Int)
    {
        /*try{
            MainScope().launch {
                var call = spotifyRepository.deletePlaylist(primaryKey)
                call.enqueue(object : Callback<Void> {

                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful()) {
                            val responseString: String? = response.code().toString()
                            if (responseString != null) {
                                //getPlayRemotelists()

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
        }*/
    }

    fun getAllPlaylists()
    {
        try
        {
            MainScope().launch {
                var call: LiveData<Resource<List<Playlist>>> = spotifyRepository.getPlaylistsSpotify()
                var list: LiveData<Resource<List<Playlist>>> = call
                list.value?.data?.forEach { p ->
                    var call: Call<List<SpotifyCover>> = spotifyRepository.getPlaylistCover(p.id)
                    var coverList = call.await()
                    if(coverList.isNotEmpty()) {
                        p.url = coverList[0].url
                    }
                }
                allPlaylists = list
                filterPlaylists()

            }
        }
        catch(e: Exception){
        }
    }

    private fun filterPlaylists()
    {
        //allPlaylists.value?.data = allPlaylists.value.data { p -> playlists.value?.data.any { it.name == p.name } == false }
    }

}