package com.example.faithandroid.models

import android.accounts.AccountManager
import org.threeten.bp.LocalDateTime

data class Adolescent (
    var city: Int,
    var avatar: Int,
    var firstName : String,
    var name: String,
    var email : String,
    var wantsConsultation: Boolean,
    var dateOfBirth : LocalDateTime
)