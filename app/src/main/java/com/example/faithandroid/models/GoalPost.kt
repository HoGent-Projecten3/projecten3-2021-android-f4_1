package com.example.faithandroid.models

import android.os.Parcelable


import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.time.LocalDateTime

@JsonClass(generateAdapter = true)
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
data class GoalPost(var id: Int = 0,
                    var title: String = "",
                    var description: String = "",
                    var completed: Boolean = false,
                    var steps: List<Step> = listOf(),
                    var date: String = "",
                    var shared : Boolean = false,
                    var name: String =""

) : Serializable


