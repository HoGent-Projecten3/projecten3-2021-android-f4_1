package com.example.faithandroid.login.data

import android.util.Log
import com.example.faithandroid.login.data.LoggedInUser
import com.example.faithandroid.login.uilogin.LoginResult
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {

    // in-memory cache of the loggedInUser object
    var user: Adolescent? = null // Adolescent
        private set

    val isLoggedIn: Boolean
        get() = user != null



    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

      fun login(username: String, password: String): Result<Adolescent> {
        // handle login
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
           // setLoggedInUser(result.data)

            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: Adolescent) { // loggedInUser: Adolescent
        this.user = loggedInUser

        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }


}