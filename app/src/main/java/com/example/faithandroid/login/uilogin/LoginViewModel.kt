package com.example.faithandroid.login.uilogin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.example.faithandroid.login.data.LoginRepository
import com.example.faithandroid.login.data.Result

import com.example.faithandroid.R
import com.example.faithandroid.login.data.User
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.*
import retrofit2.await

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

   private var _adolescent = MutableLiveData<Adolescent>()
   val adolescent: LiveData<Adolescent>
    get() = _adolescent

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

   private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, password)


        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(
                    success = LoggedInUserView(
                        displayName = result.data.firstName //result.data.firstname +" "  + result.data.name
                    )
                )
            //adolescent.value?.firstname =result.data.firstname
           // adolescent.value?.name =result.data.name
        } else {
            _loginResult.value =
                LoginResult(error = R.string.login_failed)
        }

    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value =
                LoginFormState(
                    usernameError = R.string.invalid_username
                )
        } else if (!isPasswordValid(password)) {
            _loginForm.value =
                LoginFormState(
                    passwordError = R.string.invalid_password
                )
        } else {
            _loginForm.value =
                LoginFormState(isDataValid = true)
        }

    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

   /* fun getAdolescent(username: String) {
        coroutineScope.launch {
            try {
                val adolescent = FaithApi.retrofitService.getAdolescent(username)
                val a= adolescent.email
                Log.d("adolescent", "NICE " + a)
            } catch (e: Exception) {
                Log.i("FOUT", "FOUT opgelopen")
            }
        }
    }*/
}