package com.example.faithandroid.musicRoom

import com.example.faithandroid.models.Playlist
import com.example.faithandroid.network.local.SpotifyLocalDataSource
import com.example.faithandroid.network.remote.SpotifyRemoteDataSource
import com.example.faithandroid.util.performGetOperation

class SpotifyRepository(val localDataSource: SpotifyLocalDataSource, private val remoteDataSource: SpotifyRemoteDataSource) {

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
        saveCallResult = { localDataSource.savePlayList(it.items) }
    )

    fun getPlaylistCover(cover: String) = remoteDataSource.getPlaylistCover(cover)
}
