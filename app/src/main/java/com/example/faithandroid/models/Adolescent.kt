package com.example.faithandroid.models

import android.accounts.AccountManager
import org.threeten.bp.LocalDateTime

/**
 * Class that supports the logged in adolescent
 */
data class Adolescent (
    /**
     * @param firstName is the first name of the adolescent
     * @param name is the surname of the adolescent
     * @param email is the email adress of the adolescent
     * @param wantsConsultation keeps track of whether the adolescent wants a consultation
     * @param dateOfBirth is the birthdate of the adolescent
     */
    var firstName : String,
    var name: String,
    var email : String,
    var wantsConsultation: Boolean,
    var dateOfBirth : String,
  //  var group : Group

)