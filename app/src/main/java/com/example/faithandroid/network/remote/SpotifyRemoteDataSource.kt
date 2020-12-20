package com.example.faithandroid.network.remote

import com.example.faithandroid.models.Playlist
import com.example.faithandroid.network.BaseDataSource
import com.example.faithandroid.network.FaithApiService
import com.example.faithandroid.network.SpotifyApiService

class SpotifyRemoteDataSource(private val apiService: FaithApiService, private val spotifyApiService: SpotifyApiService) : BaseDataSource() {

   fun getPlaylistsFaith() = apiService.getPlaylists()

    fun addPlaylist(playlist: Playlist) = apiService.addPlaylist(playlist)

    fun deletePlaylist(id: Int) = apiService.deletePlaylist(id)

    suspend fun getPlaylistsSpotify() =  spotifyApiService.getPlaylists()

    fun getPlaylistCover(cover: String) = spotifyApiService.getPlaylistCover(cover)
}
