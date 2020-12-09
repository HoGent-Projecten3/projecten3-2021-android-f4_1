package com.example.faithandroid.models

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoalPostFields(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "description")
    val description: String = "",
    @Json(name = "completed")
    val completed: Boolean = false,
    @Json(name = "date")
    val date: String = "",
    @Json(name = "shared")
    val shared : Boolean = false,
    @Json(name = "name")
    val name : String = ""
) : Parcelable

/*data class GoalWithSteps(
    @Embedded val goalPost: GoalPostFields,
    @Relation(
        parentColumn = "id",
        entityColumn = "goalId"
    )
    val Steps: List<StepFields>
)*/
