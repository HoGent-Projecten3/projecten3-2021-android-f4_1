package com.example.faithandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.network.FaithProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _properties = MutableLiveData<List<FaithProperty>>()

    val properties: LiveData<List<FaithProperty>>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getAdolescentsFromBob()
        postTextPost()
    }

    private fun getAdolescentsFromBob() {/*
        coroutineScope.launch {
            var getPropertiesDeferred = FaithApi.retrofitService.getProperties()
            try {
                var listResult = getPropertiesDeferred.await()
                if(listResult.size > 0){
                    _properties.value = listResult
                }
            } catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }
        }*/
    }

    private fun postTextPost(){

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
