package com.example.faithandroid.profiel



import AppPreferences


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faithandroid.login.data.LoginRepository

import com.example.faithandroid.models.Adolescent
<<<<<<< HEAD
<<<<<<< HEAD
import com.example.faithandroid.models.Avatar
import com.example.faithandroid.network.FaithApi
=======
>>>>>>> 18cbca2 (repository goalposts werkt)
=======
import com.example.faithandroid.post.PostRepository
>>>>>>> 8b69d0a (repository spotify + posts niet af)
import retrofit2.*


import kotlinx.coroutines.launch

class ProfielViewModel(private val postRepository: PostRepository): ViewModel() {


    private var _adol = MutableLiveData<Adolescent>()
    var adol: LiveData<Adolescent> = MutableLiveData<Adolescent>()
        get() = _adol

<<<<<<< HEAD

    private var _currentAvatar = MutableLiveData<Avatar>()
    var avatar: LiveData<Avatar> = MutableLiveData<Avatar>()
        get() = _currentAvatar


    fun getAdolescent(): Adolescent?{
=======
    /*fun getAdolescent(): Adolescent?{
>>>>>>> 18cbca2 (repository goalposts werkt)

        viewModelScope.launch {

            try{
            val stringCall: Call<Adolescent> =
                loginRepository.getAdolescent(AppPreferences.username.toString())

            _adol.value = stringCall.await()
            }catch(e: Exception){
                throw Exception("Gebruiker kon niet worden opgehaald")
            }
        }
        return _adol.value

    }*/

     fun changePassword(ww: String) {

         viewModelScope.launch {
             try {
                 val response = postRepository.changePassword(ww)
                 response.await()
             } catch (e: java.lang.Exception) {
                 throw e
             }
         }
    }

}