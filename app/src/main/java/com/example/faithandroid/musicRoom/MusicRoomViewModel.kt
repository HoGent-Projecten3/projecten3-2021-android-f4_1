package com.example.faithandroid.musicRoom

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.*
import com.example.faithandroid.util.Resource
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await

/**
 * Viewmodel for the Music Room
 *
 * @property allPlaylists is a list of all spotify playlists of the user
 * @property playlists is a list of the spotify playlists that are added to the app
 */
class MusicRoomViewModel(private val spotifyRepository: SpotifyRepository) : ViewModel() {

    private val _allPlaylists = MutableLiveData<List<Playlist>>()
    val allPlaylists: LiveData<List<Playlist>>
        get() = _allPlaylists

    private val _playlists = MutableLiveData<List<Playlist>>()
    val playlists: LiveData<List<Playlist>>
        get() = _playlists

    init
    {
        getPlayRemotelists()
    }



    fun getPlayRemotelists()
    {
        try {
            MainScope().launch {
                var call: Call<List<Playlist>> = spotifyRepository.getPlaylistsFaith()
                var list = call.await()
                _playlists.value = list
                filterPlaylists()
            }
        }
        catch (e: Exception )
        {
        }
    }

    fun addPlaylist(playlist: Playlist)
    {
        try{
            MainScope().launch {
                var call = spotifyRepository.addPlaylist(playlist)
                call.enqueue(object : Callback<Void> {

                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful()) {
                            val responseString: String? = response.code().toString()
                            if (responseString != null) {
                                getPlayRemotelists()

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
        }
    }

    fun deletePlaylist(primaryKey: Int)
    {
        try{
            MainScope().launch {
                var call = spotifyRepository.deletePlaylist(primaryKey)
                call.enqueue(object : Callback<Void> {

                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful()) {
                            val responseString: String? = response.code().toString()
                            if (responseString != null) {
                                getPlayRemotelists()

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
        }
    }

    fun getAllPlaylists()
    {
        try
        {
            MainScope().launch {
                var call: Call<PlaylistWrapper> = spotifyRepository.getPlaylistsSpotify()
                var list: List<Playlist> = call.await().items
                list.forEach { p ->
                    var call: Call<List<SpotifyCover>> = spotifyRepository.getPlaylistCover(p.id)
                    var coverList = call.await()
                    if(coverList.isNotEmpty()) {
                        p.url = coverList[0].url
                    }
                }
                _allPlaylists.value = list
                filterPlaylists()

            }
        }
        catch(e: Exception){
        }
    }

    private fun filterPlaylists()
    {
        _allPlaylists.value = allPlaylists.value?.filter { p -> playlists.value?.any { it.name == p.name } == false }
    }

}
