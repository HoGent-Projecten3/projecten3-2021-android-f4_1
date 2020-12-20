package com.example.faithandroid.musicRoom

import com.example.faithandroid.models.Playlist
import com.example.faithandroid.network.local.SpotifyLocalDataSource
import com.example.faithandroid.network.remote.SpotifyRemoteDataSource
import com.example.faithandroid.util.performGetOperation

class SpotifyRepository(val localDataSource: SpotifyLocalDataSource, private val remoteDataSource: SpotifyRemoteDataSource) {

    suspend fun getPlaylistsFaith() = remoteDataSource.getPlaylistsFaith()

    fun addPlaylist(playlist: Playlist) = remoteDataSource.addPlaylist(playlist)

    fun deletePlaylist(id: Int) = remoteDataSource.deletePlaylist(id)

    suspend fun getPlaylistsSpotify() = remoteDataSource.getPlaylistsSpotify()

    fun getPlaylistCover(cover: String) = remoteDataSource.getPlaylistCover(cover)
}
