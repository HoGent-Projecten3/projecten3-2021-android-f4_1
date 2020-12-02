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

class ProfielViewModel: ViewModel() {


    private var _adol = MutableLiveData<Adolescent>()
    var adol: LiveData<Adolescent> = MutableLiveData<Adolescent>()
        get() = _adol

    fun getAdolescent(): Adolescent?{

        viewModelScope.launch {

            val stringCall: Call<Adolescent> =
                FaithApi.retrofitService.getAdolescent(AppPreferences.username.toString())

            _adol.value = stringCall.await()
            Log.d("UserVM1", _adol.value.toString())
            /*stringCall.enqueue( object : Callback<Adolescent> {

                override fun onResponse(call: Call<Adolescent>, response: Response<Adolescent>) {
                    if (response.isSuccessful()) {
                        _adol.value = response.body()
                        Log.d("UserVM2", _adol.value.toString())
                    }
                    else
                    {
                        throw Exception("Gebruiker kon niet worden opgehaald")
                    }
                }

                override fun onFailure(call: Call<Adolescent>?, t: Throwable?) {
                    throw Exception("Gebruiker kon niet worden opgehaald")
                }



            })*/
        }
        return _adol.value

    }
}