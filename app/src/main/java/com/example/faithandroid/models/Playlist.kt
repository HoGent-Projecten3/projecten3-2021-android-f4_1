package com.example.faithandroid.models

data class Playlist(
    var primaryKey: Int = 0,
    var id: String,
    var name: String,
    var description: String,
    var url: String = ""
)