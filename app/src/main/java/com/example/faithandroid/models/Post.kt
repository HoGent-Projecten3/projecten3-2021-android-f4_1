package com.example.faithandroid.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post(
    var id: Int = 0,
    var title: String = "",
    var data: String = "",
    var date: String = "2020-11-05T22:34:57.61"
)