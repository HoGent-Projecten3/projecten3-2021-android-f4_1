package com.example.faithandroid.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Class that supports the steps needed to complete a goal
 *
 * @property id is the id of a step
 * @property stepText is the text that is displayed for this step
 */
@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "steps")
data class Step (
   @PrimaryKey
   val id: Int,
   val stepText: String,
   //val goalId: Int
): Parcelable
