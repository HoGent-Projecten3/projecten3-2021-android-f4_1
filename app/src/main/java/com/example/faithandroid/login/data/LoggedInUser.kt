package com.example.faithandroid.login.data

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
        /**
         * @param userId is the id of the adolescent that is logged in
         * @param displayName is the name that the logged in user is referred by
         */
        val userId: String,
        val displayName: String
)