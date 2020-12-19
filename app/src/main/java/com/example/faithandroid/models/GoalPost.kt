package com.example.faithandroid.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.time.LocalDateTime

@Parcelize
@Entity(tableName = "goalPosts")
@JsonClass(generateAdapter = true)
data class GoalPost(
    @PrimaryKey
    var id: Int,
    var title: String,
    var description: String,
    var completed: Boolean = false,
    var steps: List<Step>,
    var date: String,
    var shared : Boolean = false,
    var name : String = ""
) : Serializable,Parcelable


