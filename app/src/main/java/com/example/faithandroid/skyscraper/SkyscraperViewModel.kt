
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
import com.example.faithandroid.models.TextPost
import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.network.FaithApiService
import com.example.faithandroid.network.FaithProperty
import com.google.android.material.card.MaterialCardView
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
    private var test = mutableListOf<GoalPost>();


    val testLive: LiveData<List<GoalPost>>
        get() = testLiveData

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {

        GetPostsOfSkyscraper("dora.theexplorer1999@gmail.com")
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

                _getStatus.value = e.localizedMessage
            }
        }
    }
    fun postNewGoalPost(email: String, goalPost: GoalPost) {
        viewModelScope.launch {
            val response = FaithApi.retrofitService.postGoalPost(goalPost, email)
        }
    }

    fun goalBehaald(id:Int){
        viewModelScope.launch {
            try {
                val response = FaithApi.retrofitService.checkGoal("dora.theexplorer1999@gmail.com", id)
                _completedStatus.value = "Doel behaald".toString();

            }catch (e: HttpException) {

                _completedStatus.value = e.localizedMessage
            }
            catch (e: Exception) {

                _completedStatus.value = e.localizedMessage
            }
        }
    }

    fun shareGoal(id:Int){
        coroutineScope.launch{
            try {
                 val response = FaithApi.retrofitService.shareGoal("dora.theexplorer1999@gmail.com", id)

                response.await()
                 _shareStatus.value = "Doel gedeeld"
            } catch (e: Exception){
                Log.d("Fff", e.toString())
                _shareStatus.value = e.localizedMessage
            }
        }
    }

    fun deleteGoal(id:Int){
        coroutineScope.launch{
            try {
                val response =FaithApi.retrofitService.removeGoal(id, "dora.theexplorer1999@gmail.com");
                response.await()
                _removeStatus.value = R.string.doel_verwijderd.toString()
            } catch (e: Exception){
                Log.d("ee", e.toString())
                _removeStatus.value = e.localizedMessage
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}