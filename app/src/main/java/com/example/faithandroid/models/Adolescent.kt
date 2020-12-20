package com.example.faithandroid.models

import android.accounts.AccountManager
import org.threeten.bp.LocalDateTime

/**
 * Class that supports the logged in adolescent
 *
 * @property firstName is the first name of the adolescent
 * @property name is the surname of the adolescent
 * @property email is the email adress of the adolescent
 * @property wantsConsultation keeps track of whether the adolescent wants a consultation
 * @property dateOfBirth is the birthdate of the adolescent
 */
data class Adolescent (
    var firstName : String,
    var name: String,
    var email : String,
    var wantsConsultation: Boolean,
    var dateOfBirth : String,
  //  var group : Group

)