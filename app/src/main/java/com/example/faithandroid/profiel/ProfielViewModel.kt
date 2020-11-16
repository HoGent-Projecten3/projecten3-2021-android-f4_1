package com.example.faithandroid.profiel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faithandroid.models.ChangePassword
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.launch

class ProfielViewModel: ViewModel() {


    fun changePassword(changePasswordmodel: ChangePassword) {
        Log.d("post", "post nu nieuw wachtwoord: ${changePasswordmodel.password}")


        viewModelScope.launch {
            val response = FaithApi.retrofitService.changepassword(changePasswordmodel)
            Log.d("post", "wachtwoord veranderd")
        }

    }

}