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

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        MainScope().launch {
            val result = loginRepository.login(username, password)
            if (result is Result.Success) {

                val result2 = loginRepository.getAdolescent(username)
                if(result2 is Result.Success)
                _loginResult.value =
                    LoginResult(
                        success = LoggedInUserView(
                            token = result.data,
                            displayName =  result2.data.firstName,

                        )
                    )

            } else {
                _loginResult.value =
                    LoginResult(error = R.string.login_failed)
            }
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

    fun logout(){
        loginRepository.logout()
        _loginResult.value = null
        _loginForm.value = null
        Log.d("$$$", _loginForm.value.toString()+ " "+ _loginForm.value.toString())
    }

   /* private fun getAdolescent(username: String) {
        coroutineScope.launch {
            try {
                val adolescent = FaithApi.retrofitService.getAdolescent(username)
                 val a= adolescent.await()
                _adolescent.value = a
                Log.d("adolescent", "NICE " + a.firstName + " " +a.name)
                Log.d("HHH", _adolescent.value.toString())
            } catch (e: Exception) {
                Log.i("FOUT", "FOUT opgelopen")
            }
        }
    }*/
}