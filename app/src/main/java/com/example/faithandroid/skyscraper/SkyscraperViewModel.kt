
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

/**
 * This is the viewmodel for the skyscraper
 */
class SkyscraperViewModel : ViewModel() {
    private val _shareStatus = MutableLiveData<String>()
    private val _completedStatus = MutableLiveData<String>()
    private val _removeStatus = MutableLiveData<String>()
    private val _getStatus = MutableLiveData<String>()

    /**
     * @property shareStatus is the status of whether the goal could be shared
     * @property completedStatus is the status of whether the goal was completed
     * @property removeStatus is the status of whether the goal could be successfully removed
     * @property getStatus is the status of whether the goal could be retrieved from the backend
     */
    val shareStatus: LiveData<String>
        get() = _shareStatus

    val completedStatus: LiveData<String>
        get() = _completedStatus

    val removeStatus: LiveData<String>
        get() = _removeStatus

    val getStatus: LiveData<String>
        get() = _getStatus
  

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

    /**
     * gets the posts stored in skyscraper
     */
    fun getPostsOfSkyscraper() {
        coroutineScope.launch {
            var getPropertiesDeferred = FaithApi.retrofitService.getPostsOfSkyScraper();

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

    /**
     * posts a new goal
     *
     * @param goalPost is the goal that is to be added
     */
    fun postNewGoalPost( goalPost: GoalPost) {
        viewModelScope.launch {
            try {
                val response = FaithApi.retrofitService.postGoalPost(goalPost)
                getPostsOfSkyscraper()
            }catch (e: Exception){
                // error handling als new goal niet werkt/ er iets mis loopt
            }
        }
    }

    /**
     * checks whether a goal has been completed
     *
     * @param id is the id of the goal to be checked
     */
    fun goalBehaald(id:Int){
        viewModelScope.launch {
            try {
                val response = FaithApi.retrofitService.checkGoal(id)
                _completedStatus.value = "Doel behaald".toString();
                getPostsOfSkyscraper()

            }catch (e: HttpException) {
                _completedStatus.value = "Er liep iets mis. " + e.localizedMessage
               // _completedStatus.value = e.localizedMessage
            }
            catch (e: Exception) {
                _completedStatus.value = "Er liep iets mis"
               // _completedStatus.value = e.localizedMessage
            }
        }
    }

    /**
     * shares a goal to the billboard
     *
     * @param id is the id of the goal to be shared
     */
    fun shareGoal(id:Int){
        coroutineScope.launch{
            try {
                 val response = FaithApi.retrofitService.shareGoal(id)
                 response.await()
                getPostsOfSkyscraper()
                 _shareStatus.value = "Doel gedeeld"
            } catch (e: Exception){
                _shareStatus.value = "Er liep iets mis"
               // _shareStatus.value = e.localizedMessage
            }
        }
    }

    /**
     * Deletes a goal
     *
     * @param id is the id of the goal to be deleted
     */
    fun deleteGoal(id:Int){
        coroutineScope.launch{
            try {
                val response = FaithApi.retrofitService.removeGoal(id)
               val stringResponse= response.await()
                getPostsOfSkyscraper()
                _removeStatus.value = R.string.doel_verwijderd.toString()
            } catch (e: Exception){
                _removeStatus.value = "Er liep iets mis"
               // _removeStatus.value = e.localizedMessage
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}