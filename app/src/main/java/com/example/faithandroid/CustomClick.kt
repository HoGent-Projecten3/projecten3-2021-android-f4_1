package com.example.faithandroid

import com.example.faithandroid.models.Playlist
import com.example.faithandroid.models.Post

interface CustomClick {

    fun onClick(post: Post)
}

interface CustomPlaylistClick {
    fun onClick(playlist: Playlist): Boolean
}
interface AvatarCustomClick {
    fun onClick(avatarpart: Int)
}
