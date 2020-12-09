package com.example.faithandroid.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize


/*@Entity(foreignKeys = [ForeignKey(
   entity = GoalPost::class,
   parentColumns = arrayOf("id"),
   childColumns = arrayOf("goalId"
   ))],tableName = "steps")*/

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "steps")
data class Step (
   @PrimaryKey
   val id: Int,
   val stepText: String,
   //val goalId: Int
): Parcelable