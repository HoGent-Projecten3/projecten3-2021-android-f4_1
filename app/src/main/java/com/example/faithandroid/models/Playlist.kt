package com.example.faithandroid.models

/**
 * Class that supports the playlist in the music room
 *
 * @param primaryKey is the primary Key of the playlist on Spotify
 * @param id is the id of the playlist in the backend
 * @param name is the name of the playlist
 * @param description is a short description of what the playlist includes
 * @param url is a spotify link to the playlist
 */
data class Playlist(
    var primaryKey: Int = 0,
    var id: String,
    var name: String,
    var description: String,
    var url: String = ""
)