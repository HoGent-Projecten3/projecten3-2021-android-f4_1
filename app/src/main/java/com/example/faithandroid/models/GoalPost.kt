package com.example.faithandroid.models

import android.os.Parcelable
import org.threeten.bp.LocalDateTime

import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class GoalPost(var id: Int = 0,
                    var title: String = "",
                    var description: String = "",
                    var completed: Boolean = false,
                    var steps: List<Step> = listOf(),
                    var date: String = "2020-11-05T22:34:57.61") : Serializable







