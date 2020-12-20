package com.example.faithandroid.login.data

import java.io.Serializable

/**
 * class that supports the logging in of a user
 */
data class User (

    /**
     * @property email is the email given by the user trying to log in
     * @property password is the password given by the user trying to log in
     */
    val email : String,
    val password : String
): Serializable


