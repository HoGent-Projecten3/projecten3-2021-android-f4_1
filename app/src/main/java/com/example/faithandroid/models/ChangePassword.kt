package com.example.faithandroid.models

import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.util.*
@JsonClass(generateAdapter = true)
data class ChangePassword(
    var token : String = "",
    var userid : String = "",
    var password : String = ""

) : Serializable

