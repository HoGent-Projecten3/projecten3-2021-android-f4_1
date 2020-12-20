package com.example.faithandroid.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class PostFields(
    @Json(name = "title")
    val title: String,
    @Json(name = "data")
    val data: String,
    @Json(name = "date")
    val date: String,
    @Json(name = "postType")
    val postType: Int,
    @Json(name = "dataBytes")
    val dataBytes: String?,
    @Json(name = "url")
    val uri: String,
    @Json(name = "backpack")
    val backpack: Boolean,
    @Json(name = "bulletinBoard")
    val bulletinBoard: Boolean,
    @Json(name = "treasureChest")
    val treasureChest: Boolean
): Parcelable
