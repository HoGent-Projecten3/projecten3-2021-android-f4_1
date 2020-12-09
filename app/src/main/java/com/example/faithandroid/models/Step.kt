package com.example.faithandroid.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "steps")
@JsonClass(generateAdapter = true)
data class Step (
   @PrimaryKey
   val id: Int,
   val stepText: String
): Parcelable