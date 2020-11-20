package com.example.faithandroid.models

import android.media.Image
import com.squareup.moshi.JsonClass
import com.example.faithandroid.models.PostType.Text
import java.net.URI
import java.io.Serializable


@JsonClass(generateAdapter = true)
data class Post(
    var id: Int = 0,
    var title: String = "",
    var data: String = "",
    var date: String = "2020-11-05T22:34:57.61",
    var postType: Int,
    var dataBytes: String? = "",
    var uri: String? = ""
): Serializable

