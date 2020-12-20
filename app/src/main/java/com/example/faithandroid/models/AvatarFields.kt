package com.example.faithandroid.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
class AvatarFields(
    @Json(name = "avatarId")
    val id: Int,
    @Json(name = "person")
    val person: Int,
    @Json(name = "hair")
    val hair: Int,
    @Json(name = "eyes")
    val eyes: Int,
    @Json(name = "skin")
    val skin: Int,
    @Json(name = "upperbody")
    val upperBody: Int
) : Parcelable
