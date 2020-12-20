package com.example.faithandroid.login.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.load.engine.Resource
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.Response.success
import kotlin.Result.Companion.success

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 *
 * @property status shows whether the API call was successful
 * @property loggedInUser is the logged in user
 */
class LoginDataSource {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status


    private val _loggedInUser = MutableLiveData<Adolescent>()
    val loggedInUser: LiveData<Adolescent>
        get() = _loggedInUser

    private var ado: Adolescent? = null

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    /**
     * Logs the user in
     *
     * @return the result of logging in
     */
      suspend fun login(username: String, password: String): Result<String>{

              try {
                  val stringCall: Call<String> =
                      FaithApi.retrofitService.loginAdolescent(User(username, password))
                  var token = stringCall.await()
                  return Result.Success(token)
              } catch (e: Exception) {
                  return Result.Error(e.message.toString())
              }
    }
    /**
     * gets the information of the adolescent from the backend
     *
     * @param username is the username by which the adolescent is retrieved from the backend
     * @return the result of getting the adolescent
     */
    suspend fun getAdolescent(username: String): Result<Adolescent> {

            try {
                val adolescent = FaithApi.retrofitService.getAdolescent(username)
                val a = adolescent.await()
                return Result.Success(a)

            } catch (e: HttpException) {
                return Result.Error(e.message())
            }
    }

   /* fun logout() {
        // TODO: revoke authentication
    }*/
}


