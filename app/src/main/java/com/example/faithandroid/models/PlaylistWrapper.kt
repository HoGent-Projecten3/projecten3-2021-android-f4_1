package com.example.faithandroid.models

/**
 * class that is needed to convert from Spotify
 *
 * @property items is a list of playlists that Spotify gives
 */
data class PlaylistWrapper(
    var items: List<Playlist>
)
