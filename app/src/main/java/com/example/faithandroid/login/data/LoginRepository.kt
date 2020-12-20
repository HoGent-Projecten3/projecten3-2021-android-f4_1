package com.example.faithandroid.login.data

import com.example.faithandroid.models.Adolescent
import kotlinx.coroutines.*

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 *
 * @param dataSource handles authentication w/ login credentials and retrieves user information
 * @property user is the adolescent
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

    /**
     * logs out the user
     */
    fun logout() {
        user = null
        //dataSource.logout()
    }

    /**
     * gets a specific adolescent
     *
     * @param username is the name by which the correct adolescent can be searched
     * @return the result of getting the adolescent
     */
    suspend fun getAdolescent(username: String): Result<Adolescent>
    {

        Log.d("tag", username)

        val result2 = dataSource.getAdolescent(username)

        if (result2 is Result.Success) {
            setLoggedInUser(result2.data)
            return result2
        }
        else
        {
           return Result.Error(result2.toString())
        }


    }

    /**
     * logs in the user
     *
     * @param username is the username given by the user trying to log in
     * @param password is the password given by the user trying to log in
     * @return the result of logging in
     */
      suspend fun  login(username: String, password: String): Result<String> {
          // handle login

              val result = dataSource.login(username, password)

              if (result is Result.Success) {
                  AppPreferences.token = result.data
                  return result

              }
              else
              {
                  return Result.Error(result.toString())
              }

      }

    /**
     * sets an Adolescent as the logged in user
     *
     * @param loggedInUser is the user to be set as the logged in user
     */
    private fun setLoggedInUser(loggedInUser: Adolescent) { // loggedInUser: Adolescent
        this.user = loggedInUser

        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }


}
