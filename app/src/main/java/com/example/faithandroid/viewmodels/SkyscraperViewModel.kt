
package com.example.faithandroid.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.TextPost
import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.network.FaithApiService
import com.example.faithandroid.network.FaithProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDateTime
import retrofit2.Retrofit
import retrofit2.await


class SkyscraperViewModel : ViewModel() {

    var test = mutableListOf<GoalPost>()
    private var testLiveData = MutableLiveData<List<GoalPost>>()

    val testLive: LiveData<List<GoalPost>>
        get() = testLiveData

    fun addGoalPost(goal: GoalPost){
        testLiveData.value = (testLiveData.value)?.plus(goal)
    }

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        GetPostsOfSkyscraper("dora.theexplorer1999@gmail.com")
    }

    private fun GetPostsOfSkyscraper(email: String) {
        coroutineScope.launch {
            var getPropertiesDeferred = FaithApi.retrofitService.getPostsOfSkyScraperByAdolescentEmail(email);
            try {
                var listResult = getPropertiesDeferred.await()
                if(listResult.size > 0){

                    testLiveData.value = listResult
                }
            } catch (e: Exception){

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


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}