package com.example.faithandroid.profiel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.network.FaithApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ProfielViewModel: ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    lateinit var adol: Adolescent

    fun getAdolescent(): Adolescent{
        coroutineScope.launch{
            try{
                Log.d("User",AppPreferences.username.toString())
                Log.d("User", AppPreferences.username.toString())
                var ad =  FaithApi.retrofitService.getAdolescent(AppPreferences.username.toString())
                adol = ad.await()
                Log.d("UserVM", adol.toString())
            }catch (e: Exception){
                throw Exception(e.message)
            }
        }

        return adol

    }
}