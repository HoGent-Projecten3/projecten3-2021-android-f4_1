package com.example.faithandroid.network.local

import androidx.lifecycle.LiveData
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Playlist

class SpotifyLocalDataSource(private val spotifyDao: SpotifyDao) {

    fun getPlaylists() = spotifyDao.getPlaylists()

    fun savePlayList(list: List<Playlist>) = spotifyDao.insertAll(list)
}