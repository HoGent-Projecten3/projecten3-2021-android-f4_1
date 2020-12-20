package com.example.faithandroid.network.local

import com.example.faithandroid.models.Playlist

class SpotifyLocalDataSource(private val spotifyDao: SpotifyDao) {

    fun getPlaylists() = spotifyDao.getPlaylists()

    fun savePlayList(list: List<Playlist>) = spotifyDao.insertAll(list)
}
