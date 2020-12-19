package com.example.faithandroid.network.remote

import com.example.faithandroid.models.Playlist
import com.example.faithandroid.network.BaseDataSource
import com.example.faithandroid.network.FaithApiService
import com.example.faithandroid.network.SpotifyApiService

class SpotifyRemoteDataSource(private val apiService: FaithApiService, private  val spotifyApiService: SpotifyApiService): BaseDataSource() {

    suspend fun getPlaylistsFaith() = getResult { apiService.getPlaylists() }

    fun addPlaylist(playlist: Playlist) = apiService.addPlaylist(playlist)

    fun deletePlaylist(id: Int) = apiService.deletePlaylist(id)

    fun getUser() = spotifyApiService.getUser()

    suspend fun getPlaylistsSpotify() = getObjectResult { spotifyApiService.getPlaylists() }

    fun getPlaylistCover(cover: String) = spotifyApiService.getPlaylistCover(cover)
}