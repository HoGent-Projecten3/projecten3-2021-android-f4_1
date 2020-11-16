package com.example.faithandroid.login.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.network.FaithApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status


    private val _loggedInUser = MutableLiveData<Adolescent>()
    val loggedInUser: LiveData<Adolescent>
        get() = _loggedInUser
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

      fun login(username: String, password: String): Result<Adolescent>{
          val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), username)
//          coroutineScope.launch {
//              try {
//                  // TODO: handle loggedInUser authentication
//
//                  var tokenAdolescent=  FaithApi.retrofitService.loginAdolescent(User("dora.theexplorer1999@gmail.com", "ZwieberNee!NietStelen1"))
//                  val token = tokenAdolescent
//
//                  Log.d("token", "DIT IS DE "+ token.await())
//
//
//
//
//                  //  val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
//                  //return Result.Success(fakeUser)
//              } catch (e: Throwable) {
//                  //return Result.Error(IOException("ERROR logging in", e))
//                  Log.d("token", e.localizedMessage)
//              }
//          }
//
//          return Result.Success( fakeUser)
          //var loggedInUser: Adolescent = Adolescent(-1, -1, "", "", "", false, "")
          val stringCall: Call<String> = FaithApi.retrofitService.loginAdolescent(User("dora.theexplorer1999@gmail.com", "ZwieberNee!NietStelen1"))
          stringCall.enqueue(object : Callback<String> {
              override fun onResponse(call: Call<String>, response: Response<String>) {
                  if (response.isSuccessful()) {
                      val responseString: String? = response.body()
                      // todo: do something with the response string
                      if (responseString != null) {
                          Log.d("tokenn", responseString)
                          coroutineScope.launch {
                              _loggedInUser.value = FaithApi.retrofitService.GetAdolescent("dora.theexplorer1999@gmail.com").await()
                              Log.d("user", loggedInUser.value!!.firstName)

                          }

                      }
                  }
              }

              override fun onFailure(call: Call<String?>?, t: Throwable?) {
                  t?.localizedMessage?.let { Log.d("errorr", it) }
                  Log.d("errorr", "zonder error")
              }
          })

          Log.d("preuser", "test")
          _loggedInUser.value?.firstName?.let { Log.d("user", it) }
          return Result.Success(loggedInUser.value!!)

    }

    fun logout() {
        // TODO: revoke authentication
    }
}