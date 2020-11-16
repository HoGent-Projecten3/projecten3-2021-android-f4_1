package com.example.faithandroid.login.data

import android.accounts.AccountManager
import android.util.Log
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.skyscraper.addGoalFragment
import retrofit2.await
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

      fun login(username: String, password: String): Result<LoggedInUser>{
        try {
            // TODO: handle loggedInUser authentication

         var tokenAdolescent=  FaithApi.retrofitService.loginAdolescent(User("dora.theexplorer1999@gmail.com", "ZwieberNee!NietStelen1"))
            val token = tokenAdolescent

            Log.d("token", "DIT IS DE "+ token)


        val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), username)
            return Result.Success( fakeUser)
          //  val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            //return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("ERROR logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}