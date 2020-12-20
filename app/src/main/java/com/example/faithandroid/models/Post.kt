package com.example.faithandroid.models

import android.media.Image
import com.squareup.moshi.JsonClass
import com.example.faithandroid.models.PostType.Text
import java.net.URI
import java.io.Serializable


@JsonClass(generateAdapter = true)
/**
 * Class that supports the posts in the backpack, bulletinboard and treasure chest
 *
 * @property id is the id of the post
 * @property title is the title of the post
 * @property data -----------------????---------------- Isn't the data at the uri?
 * @property date is the date the post was created
 * @property postType is the type of the post (video, audio, text or image)
 * @property dataBytes -----------------????-------------------
 * @property uri is the link to the post
 */
data class Post(
    var id: Int = 0,
    var title: String = "",
    var data: String = "",
    var date: String = "2020-11-05T22:34:57.61",
    var postType: Int,
    var dataBytes: String? = "",
    var uri: String? = ""
): Serializable

