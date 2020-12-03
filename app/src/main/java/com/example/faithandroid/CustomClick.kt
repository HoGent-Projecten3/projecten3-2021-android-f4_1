package com.example.faithandroid

import com.example.faithandroid.models.Post

interface CustomClick {

    fun onClick(post: Post)
}

interface AvatarCustomClick{
    fun onClick(avatarpart: Int)
}