package com.example.faithandroid.network.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.faithandroid.models.Playlist

@Dao
interface SpotifyDao {

    @Query("select * from playlists")
    fun getPlaylists(): LiveData<List<Playlist>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Playlist>)
}