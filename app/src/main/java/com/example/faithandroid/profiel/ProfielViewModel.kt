package com.example.faithandroid.profiel


import AppPreferences

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.models.Post
import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.network.FaithApiService
import kotlinx.coroutines.*
import retrofit2.*
import retrofit2.awaitResponse

import com.example.faithandroid.models.ChangePassword
import kotlinx.coroutines.launch

class ProfielViewModel: ViewModel() {


    private var _adol = MutableLiveData<Adolescent>()
    var adol: LiveData<Adolescent> = MutableLiveData<Adolescent>()
        get() = _adol

    fun getAdolescent(): Adolescent?{

        viewModelScope.launch {

            try{
            val stringCall: Call<Adolescent> =
                FaithApi.retrofitService.getAdolescent(AppPreferences.username.toString())

            _adol.value = stringCall.await()
            }catch(e: Exception){
                throw Exception("Gebruiker kon niet worden opgehaald")
            }
        }
        return _adol.value

    }

    fun changePassword(changePasswordmodel: ChangePassword) {
        Log.d("post", "post nu nieuw wachtwoord: ${changePasswordmodel.password}")


        viewModelScope.launch {
            val response = FaithApi.retrofitService.changepassword(changePasswordmodel)
            Log.d("post", "wachtwoord veranderd")
        }

    }


}