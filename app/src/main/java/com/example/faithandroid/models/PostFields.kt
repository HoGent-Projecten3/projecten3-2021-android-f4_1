package com.example.faithandroid.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class PostFields(
    @Json(name = "id")
    var id: Int = 0,
    @Json(name = "title")
    var title: String = "",
    @Json(name = "data")
    var data: String = "",
    @Json(name = "date")
    var date: String = "2020-11-05T22:34:57.61",
    @Json(name = "postType")
    var postType: Int,
    @Json(name = "dataBytes")
    var dataBytes: String? = "",
    @Json(name = "url")
    var uri: String? = ""
): Parcelable
