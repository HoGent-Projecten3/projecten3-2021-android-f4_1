package com.example.faithandroid.profiel



import AppPreferences

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faithandroid.login.data.LoginRepository
import com.example.faithandroid.login.data.Result
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.models.Avatar
import com.example.faithandroid.post.PostRepository
import retrofit2.*
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class ProfielViewModel(private val postRepository: PostRepository,private val loginRepository: LoginRepository): ViewModel() {


    private var _adol = MutableLiveData<Adolescent>()
    var adol: LiveData<Adolescent> = MutableLiveData<Adolescent>()
        get() = _adol

    private var _currentAvatar = MutableLiveData<Avatar>()
    var avatar: LiveData<Avatar> = MutableLiveData<Avatar>()
        get() = _currentAvatar

    fun getAdolescent(): Adolescent?{

        viewModelScope.launch {

            try{
            val stringCall: Result<Adolescent> =
                loginRepository.getAdolescent(AppPreferences.username.toString())
            if(stringCall is Result.Success){
                _adol.value = stringCall.data
            }else{
                throw Exception()
            }
            }catch(e: Exception){
                throw Exception("Gebruiker kon niet worden opgehaald")
            }
        }
        return _adol.value

    }

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