package com.example.faithandroid.models

import android.accounts.AccountManager
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.LocalDateTime

import java.io.Serializable
        /**
         * Class that supports the avatar of an adolescent
         *
         * @property person is the 'character' of the logged in user
         * @property hair is the haircolor of the avatar
         * @property eyes are the color of the eyes
         * @property skin is the skintone of the avatar
         * @property upperBody is the color of the clothes of the avatar
         */
@Parcelize
@Entity(tableName = "avatar")
@JsonClass(generateAdapter = true)
data class Avatar (
    @PrimaryKey
    var id: Int,
    var person : Int,
    var hair: Int,
    var eyes : Int,
    var skin: Int,
    var upperBody : Int
): Serializable, Parcelable