package com.example.faithandroid.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlaylistFields(
    @Json(name = "primaryKey")
    val primaryKey: Int = 0,
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "url")
    val url: String = ""
): Parcelable