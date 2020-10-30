package com.example.faithandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.network.FaithProperty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getAdolescentsFromBob()
    }

    private fun getAdolescentsFromBob() {
        FaithApi.retrofitService.getProperties().enqueue( object: Callback<List<FaithProperty>> {
            override fun onFailure(call: Call<List<FaithProperty>>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<List<FaithProperty>>, response: Response<List<FaithProperty>>) {
                _response.value = "Success: ${response.body()?.size} Faith properties retrieved"
            }
        })
        _response.value = "Set the Faith API Response here!"
    }
}
