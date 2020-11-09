
package com.example.faithandroid.skyscraper

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faithandroid.R
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Step
import com.example.faithandroid.models.TextPost
import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.network.FaithApiService
import com.example.faithandroid.network.FaithProperty
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDateTime
import retrofit2.Retrofit
import retrofit2.await


class SkyscraperViewModel : ViewModel() {
    private val _shareStatus = MutableLiveData<String>()
    private val _completedStatus = MutableLiveData<String>()
    private val _removeStatus = MutableLiveData<String>()
    private val _getStatus = MutableLiveData<String>()

    val shareStatus: LiveData<String>
        get() = _shareStatus

    val completedStatus: LiveData<String>
        get() = _completedStatus

    val removeStatus: LiveData<String>
        get() = _removeStatus

    val getStatus: LiveData<String>
        get() = _getStatus
  
    private var testLiveData = MutableLiveData<List<GoalPost>>()
    private var test = mutableListOf<GoalPost>(GoalPost(0,"Test","Test", false, listOf(Step(0,"test"), Step(1, "Nog een test"), Step(2, "Oh boy nog een test")), "test"));


    val testLive: LiveData<List<GoalPost>>
        get() = testLiveData

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {

        //GetPostsOfSkyscraper("dora.theexplorer1999@gmail.com")
        testLiveData.value = test;
    }

    fun GetPostsOfSkyscraper(email: String) {
        coroutineScope.launch {
            var getPropertiesDeferred = FaithApi.retrofitService.getPostsOfSkyScraperByAdolescentEmail(email);
            try {
                var listResult = getPropertiesDeferred.await()
                if(listResult.size > 0){

                    testLiveData.value = listResult
                }
            } catch (e: Exception){
                Log.d("lalala",e.localizedMessage)
                _getStatus.value = e.localizedMessage
            }
        }
    }

    fun goalBehaald(id:Int){
        viewModelScope.launch {
            try {
                FaithApi.retrofitService.checkGoal("dora.theexplorer1999@gmail.com", id)
                Log.d("editGoal", "Goal checked")
                _completedStatus.value = R.string.doel_gedeeld.toString();
            } catch (e: Exception) {
                _completedStatus.value = e.localizedMessage
            }
        }
    }

    fun postNewGoalPost(email: String, goalPost: GoalPost) {
        Log.d("post", "Begint nu met posten")
        viewModelScope.launch {
            val response = FaithApi.retrofitService.postGoalPost(goalPost, email)
            //Log.d("post", response.message())
            Log.d("post", "Gepost")
        }

    }

    fun shareGoal(id:Int){
        coroutineScope.launch{
            try {
                FaithApi.retrofitService.shareGoal("dora.theexplorer1999@gmail.com", id);
                _shareStatus.value = R.string.doel_gedeeld.toString();
            } catch (e: Exception){
                _shareStatus.value = e.localizedMessage
            }
        }
    }

    fun deleteGoal(id:Int){
        coroutineScope.launch{
            try {
                FaithApi.retrofitService.removeGoal(id, "dora.theexplorer1999@gmail.com");
                _removeStatus.value = R.string.doel_verwijderd.toString()
            } catch (e: Exception){
                _removeStatus.value = e.localizedMessage
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}