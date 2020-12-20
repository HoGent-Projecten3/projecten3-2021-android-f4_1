package com.example.faithandroid.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize


/**
 * Class that supports the playlist in the music room
 *
 * @param primaryKey is the primary Key of the playlist on Spotify
 * @param id is the id of the playlist in the backend
 * @param name is the name of the playlist
 * @param description is a short description of what the playlist includes
 * @param url is a spotify link to the playlist
 */
@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "playlists")
data class Playlist(
    @PrimaryKey
    var primaryKey: Int = 0,
    var id: String,
    var name: String,
    var description: String,
    var url: String = ""
): Parcelable