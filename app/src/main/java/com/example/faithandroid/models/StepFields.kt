package com.example.faithandroid.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StepFields (
    @Json(name = "id")
    val id: Int,
    @Json(name = "goalId")
    val goalId: Int,
    @Json(name = "stepText")
    val stepText: String
): Parcelable