package com.example.faithandroid.models

import android.accounts.AccountManager
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.LocalDateTime
import java.io.Serializable

@Parcelize
@Entity(tableName = "avatar")
@JsonClass(generateAdapter = true)
data class Avatar (
    //var city: Int,
    //var avatar: Int,
    @PrimaryKey
    var id: Int,
    var person : Int,
    var hair: Int,
    var eyes : Int,
    var skin: Int,
    var upperBody : Int
): Serializable, Parcelable