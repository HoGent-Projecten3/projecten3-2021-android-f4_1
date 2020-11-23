package com.example.faithandroid.login.data

import android.util.Log
import com.example.faithandroid.login.data.LoggedInUser
import com.example.faithandroid.login.uilogin.LoginResult
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.*
import java.lang.NullPointerException

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

      suspend fun  login(username: String, password: String): Result<Adolescent> {
          // handle login

          var result2: Result<Adolescent>? = null


              val result = dataSource.login(username, password)

              if (result is Result.Success) {
                  result2 = dataSource.getAdolescent(username)
                  if (result2 is Result.Success) {

                      setLoggedInUser((result2).data)


                  }
              }

          if (result2 != null)
          {
              return result2
          }
          else
          {
              throw NullPointerException()
          }

      }

    private fun setLoggedInUser(loggedInUser: Adolescent) { // loggedInUser: Adolescent
        this.user = loggedInUser

        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }


}
