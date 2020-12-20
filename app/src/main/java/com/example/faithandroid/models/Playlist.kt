package com.example.faithandroid.models

/**
 * Class that supports the playlist in the music room
 *
 * @property primaryKey is the primary Key of the playlist
 * @property id --------------------????------------------Why do we need an id when we have a primary key?
 * @property name is the name of the playlist
 * @property description is a short description of what the playlist includes
 * @property url is a spotify link to the playlist
 */
data class Playlist(
    var primaryKey: Int = 0,
    var id: String,
    var name: String,
    var description: String,
    var url: String = ""
)