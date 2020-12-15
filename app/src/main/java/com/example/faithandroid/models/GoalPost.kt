package com.example.faithandroid.models

import android.os.Parcelable


import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.time.LocalDateTime

@JsonClass(generateAdapter = true)
data class GoalPost(var id: Int = 0,
                    var title: String = "",
                    var description: String = "",
                    var completed: Boolean = false,
                    var steps: List<Step> = listOf(),
                    var date: String = "",
                    var shared : Boolean = false,
                    var name: String =""

) : Serializable


