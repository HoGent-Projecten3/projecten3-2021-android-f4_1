package com.example.faithandroid.musicRoom

import com.example.faithandroid.models.Playlist
import com.example.faithandroid.network.local.GoalPostLocalDataSource
import com.example.faithandroid.network.local.SpotifyLocalDataSource
import com.example.faithandroid.network.remote.GoalPostRemoteDataSource
import com.example.faithandroid.network.remote.SpotifyRemoteDataSource
import com.example.faithandroid.util.performGetOperation
import retrofit2.http.Body
import retrofit2.http.Path

class SpotifyRepository(val localDataSource: SpotifyLocalDataSource,private val remoteDataSource: SpotifyRemoteDataSource)
{

     fun getPlaylistsFaith() = performGetOperation(

    databaseQuery = { localDataSource.getPlaylists() },
    networkCall = { remoteDataSource.getPlaylistsFaith() },
    saveCallResult = { localDataSource.savePlayList(it) }
    )

     fun addPlaylist(playlist: Playlist) = remoteDataSource.addPlaylist(playlist)

     fun deletePlaylist(id: Int) = remoteDataSource.deletePlaylist(id)

     fun getPlaylistsSpotify() = performGetOperation(

        databaseQuery = { localDataSource.getPlaylists() },
        networkCall = { remoteDataSource.getPlaylistsSpotify() },
<<<<<<< HEAD
<<<<<<< HEAD
        saveCallResult = { localDataSource.savePlayList(it.items) }
=======
        saveCallResult = { localDataSource.savePlayList(it) }
>>>>>>> 8b69d0a (repository spotify + posts niet af)
=======
        saveCallResult = { localDataSource.savePlayList(it.items) }
>>>>>>> 97bc67a (kleine aanpassingen)
    )

    fun getPlaylistCover(cover: String) = remoteDataSource.getPlaylistCover(cover)
}