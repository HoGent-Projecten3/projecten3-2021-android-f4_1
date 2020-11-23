package com.example.faithandroid.login.uilogin

import com.example.faithandroid.login.uilogin.LoggedInUserView

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
        val success: LoggedInUserView? = null,
        val error: Int? = null
)