package com.example.faithandroid.login.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    private var ado: Adolescent? = null


    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

      fun login(username: String, password: String): Result<Adolescent>{

           coroutineScope.launch {

                //var loggedInUser: Adolescent = Adolescent(-1, -1, "", "", "", false, "")
                // /*"dora.theexplorer1999@gmail.com", "ZwieberNee!NietStelen1"*/
                val stringCall: Call<String> =
                    FaithApi.retrofitService.loginAdolescent(User(username, password))
                stringCall.enqueue(object : Callback<String> {

                    override fun onResponse(call: Call<String>, response: Response<String>) {
                        if (response.isSuccessful()) {
                            val responseString: String? = response.body()

                            if (responseString != null) {
                                Log.d("TOKEN", responseString)
                                  getAdolescent(username)
                              /*  coroutineScope.launch {//dora.theexplorer1999@gmail.com
                                    val user =
                                        FaithApi.retrofitService.GetAdolescent(username).await()
                                    Log.d("USER INFO",user.toString())
                                    _loggedInUser.value = user
                                    Log.d("user", loggedInUser.value!!.firstName)

                                }*/

                            }
                        }
                    }

                    override fun onFailure(call: Call<String?>?, t: Throwable?) {
                        t?.localizedMessage?.let { Log.d("errorr", it) }
                        Log.d("errorr", "zonder error")
                    }
                })

            }
          val user = LoggedInUser(java.util.UUID.randomUUID().toString(), username)

          Log.d("TEST", user.userId + " " +user.displayName)
       /*    Log.d("preuser", "test")
          _loggedInUser.value?.firstName?.let { Log.d("user", it) }
          Log.d("USER", loggedInUser.value.toString())*/
         // return  Result.Success(loggedInUser.value!!)
        return Result.Success(ado!!)
    }
    private fun getAdolescent(username: String) {
        coroutineScope.launch {
            try {
                val adolescent = FaithApi.retrofitService.getAdolescent(username)
                val a= adolescent.await()
                ado = a
                Log.d("adolescent", "NICE " + a.firstName + " " +a.name)
             //   Log.d("HHH", ado.value.toString())
            } catch (e: Exception) {
                Log.i("FOUT", "FOUT opgelopen")
            }
        }

    }

    fun logout() {
        // TODO: revoke authentication
    }
}