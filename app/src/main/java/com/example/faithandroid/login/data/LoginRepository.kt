package com.example.faithandroid.login.data

import android.util.Log
import com.example.faithandroid.login.data.LoggedInUser
import com.example.faithandroid.login.uilogin.LoginResult
import com.example.faithandroid.models.Adolescent
import kotlinx.coroutines.*
import retrofit2.await
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

    var token: String = ""

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        //dataSource.logout()
    }

    suspend fun getAdolescent(username: String): Result<Adolescent>
    {
<<<<<<< HEAD
=======

        Log.d("tag", username)
>>>>>>> b670cfb (Delen billboard aangepast)
        val result2 = dataSource.getAdolescent(username)

        if (result2 is Result.Success) {
            Log.d("tag", result2.data.toString())
            setLoggedInUser(result2.data)
            return result2
        }
        else
        {
            throw NullPointerException()
        }


    }

      suspend fun  login(username: String, password: String): Result<String> {
          // handle login

              val result = dataSource.login(username, password)

              if (result is Result.Success) {
                  AppPreferences.token = result.data
                  return result

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
