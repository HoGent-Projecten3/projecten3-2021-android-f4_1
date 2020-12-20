package com.example.faithandroid.login.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.network.FaithApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import retrofit2.*

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource(private val apiService: FaithApiService) {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _loggedInUser = MutableLiveData<Adolescent>()
    val loggedInUser: LiveData<Adolescent>
        get() = _loggedInUser

    private var ado: Adolescent? = null

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    suspend fun login(username: String, password: String): Result<String> {
        try {
            val stringCall: Call<String> =
                apiService.loginAdolescent(User(username, password))
            var token = stringCall.await()
            return Result.Success(token)
        } catch (e: Exception) {
            return Result.Error(e.message.toString())
        }
    }
    suspend fun getAdolescent(username: String): Result<Adolescent> {

        try {
            val adolescent = apiService.getAdolescent(username)
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
