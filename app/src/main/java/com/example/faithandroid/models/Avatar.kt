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
     * @param person is the 'character' of the logged in user
     * @param hair is the haircolor of the avatar
     * @param eyes are the color of the eyes
     * @param skin is the skintone of the avatar
     * @param upperBody is the color of the clothes of the avatar
     */
    var person : Int,
    var hair: Int,
    var eyes : Int,
    var skin: Int,
    var upperBody : Int
)