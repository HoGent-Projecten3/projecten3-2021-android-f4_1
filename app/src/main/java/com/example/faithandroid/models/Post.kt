package com.example.faithandroid.models

import com.squareup.moshi.JsonClass
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

//{
//    "title": "string",
//    "data": "string",
//    "date": "2020-11-19T13:08:20.126Z",
//    "postType": 0,
//    "dataBytes": "string",
//    "uri": "string"
//}