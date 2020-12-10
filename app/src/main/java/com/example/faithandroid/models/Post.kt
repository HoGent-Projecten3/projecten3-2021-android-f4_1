package com.example.faithandroid.models

import android.media.Image
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import com.example.faithandroid.models.PostType.Text
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.net.URI
import java.io.Serializable

@Parcelize
@Entity(tableName = "posts")
@JsonClass(generateAdapter = true)
data class Post(
    @PrimaryKey
    var id: Int = 0,
    var title: String = "",
    var data: String = "",
    var date: String = "2020-11-05T22:34:57.61",
    var postType: Int,
    var dataBytes: String? = "",
    var uri: String? = "",
    var backpack: Boolean,
    var bulletinBoard: Boolean,
    var treasureChest: Boolean
): Serializable,Parcelable

