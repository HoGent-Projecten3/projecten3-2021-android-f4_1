package com.example.faithandroid.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.time.LocalDateTime

/**
 * Class that supports the goals in the skyscraper and billboard
 *
 * @param id is the id of the goal
 * @param title is the title of the goal
 * @param description is a short description of what the goal is
 * @param completed keeps track of whether the goal has been completed
 * @param steps is a list of steps needed to complete the goal
 * @param date is the date the goal was created
 * @param shared keeps track of whether the goal is shared to the billboard
 * @param name is the name of the user
 */
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


