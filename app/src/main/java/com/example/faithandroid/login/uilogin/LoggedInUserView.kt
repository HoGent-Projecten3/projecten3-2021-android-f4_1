package com.example.faithandroid.login.uilogin

/**
 * User details post authentication that is exposed to the UI
 */
data class LoggedInUserView(
    val displayName: String,
    val token: String,
    val email: String
    // ... other data fields that may be accessible to the UI
)
