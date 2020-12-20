package com.example.faithandroid.models

import android.os.Parcelable


import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.time.LocalDateTime

@JsonClass(generateAdapter = true)
/**
 * Class that supports the goals in the skyscraper and billboard
 *
 * @property id is the id of the goal
 * @property title is the title of the goal
 * @property description is a short description of what the goal is
 * @property completed keeps track of whether the goal has been completed
 * @property steps is a list of steps needed to complete the goal
 * @property date is the date the goal was created
 * @property shared keeps track of whether the goal is shared to the billboard
 * @property name is the name of the user
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


