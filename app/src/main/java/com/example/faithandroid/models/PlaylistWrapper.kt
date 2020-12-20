package com.example.faithandroid.models

/**
 * class that is needed to convert from Spotify
 */
data class PlaylistWrapper(
    /**
     * @property items is a list of playlists that Spotify gives
     */
    var items: List<Playlist>
)