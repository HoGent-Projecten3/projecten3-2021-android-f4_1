
package com.example.faithandroid.skyscraper

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faithandroid.R
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Step

import com.example.faithandroid.models.Post

import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.network.FaithApiService
import com.example.faithandroid.network.FaithProperty
import com.google.android.material.card.MaterialCardView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDateTime
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.await


class SkyscraperViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()
    val getStatus: LiveData<String>
        get() = _status
  

    private var test = mutableListOf<GoalPost>();

    private var testLiveData = MutableLiveData<List<GoalPost>>()
    val testLive: LiveData<List<GoalPost>>
        get() = testLiveData

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {

        getPostsOfSkyscraper()
        testLiveData.value = test;
    }

    fun getPostsOfSkyscraper() {
        coroutineScope.launch {
            var getPropertiesDeferred = FaithApi.retrofitService.getPostsOfSkyScraper();

            try {

                var listResult = getPropertiesDeferred.await()
                if(listResult.size > 0){

                    testLiveData.value = listResult
                }

            } catch (e: Exception){

                _status.value = e.localizedMessage
            }
        }
    }
    fun postNewGoalPost( goalPost: GoalPost) {
        viewModelScope.launch {
            try {
                val response = FaithApi.retrofitService.postGoalPost(goalPost)
                getPostsOfSkyscraper()
            }catch (e: Exception){
                // error handling als new goal niet werkt/ er iets mis loopt
                _status.value = e.localizedMessage
            }
        }
    }

    fun goalBehaald(id:Int){
        viewModelScope.launch {
            try {
                val response = FaithApi.retrofitService.checkGoal(id)
                _status.value = "Doel behaald"
                getPostsOfSkyscraper()

            }catch (e: HttpException) {
                _status.value = "Er liep iets mis" + e.localizedMessage
            }
            catch (e: Exception) {
                _status.value = "Er liep iets mis"
            }
        }
    }

    fun shareGoal(id:Int){
        coroutineScope.launch{
            try {
                 val response = FaithApi.retrofitService.shareGoal(id)
                 response.await()
                getPostsOfSkyscraper()
                _status.value = "Doel gedeeld"
            } catch (e: Exception){
                _status.value = "Er liep iets mis"
            }
        }
    }

    fun deleteGoal(id:Int){
        coroutineScope.launch{
            try {
                val response = FaithApi.retrofitService.removeGoal(id)
               val stringResponse= response.await()
                getPostsOfSkyscraper()
                _status.value = "Doel verwijderd";
            } catch (e: Exception){
                _status.value = "Er liep iets mis"
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}