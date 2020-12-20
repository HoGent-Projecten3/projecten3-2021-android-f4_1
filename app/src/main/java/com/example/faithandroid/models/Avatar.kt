package com.example.faithandroid.models

import android.accounts.AccountManager
import org.threeten.bp.LocalDateTime
/**
 * Class that supports the avatar of an adolescent
 */
data class Avatar (
    //var city: Int,
    //var avatar: Int,

    /**
     * @property person is the 'character' of the logged in user
     * @property hair is the haircolor of the avatar
     * @property eyes are the color of the eyes
     * @property skin is the skintone of the avatar
     * @property upperBody is the color of the clothes of the avatar
     */
    var person : Int,
    var hair: Int,
    var eyes : Int,
    var skin: Int,
    var upperBody : Int
)