package com.example.faithandroid.login.data

import java.io.Serializable

/**
 * class that supports the logging in of a user
 *
 * @property email is the email given by the user trying to log in
 * @property password is the password given by the user trying to log in
 */
data class User (

    val email : String,
    val password : String
): Serializable


