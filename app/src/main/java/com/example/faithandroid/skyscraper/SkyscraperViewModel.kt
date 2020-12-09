
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

import com.example.faithandroid.network.FaithProperty
import com.example.faithandroid.util.Resource
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


class SkyscraperViewModel(private val goalPostRepository: GoalPostRepository) : ViewModel() {
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
  

    private var test = mutableListOf<GoalPost>();

    var testLive : LiveData<Resource<List<GoalPost>>> = goalPostRepository.getPostsOfSkyScraper()


    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    /*init {

        getPostsOfSkyscraper()
        testLiveData.value = test;
    }

    fun getPostsOfSkyscraper() {
        coroutineScope.launch {
            var getPropertiesDeferred = goalPostRepository.getPostsOfSkyScraper();

            try {

                var listResult = getPropertiesDeferred
                if(listResult.value?.data != null){

                    testLiveData = listResult
                }

            } catch (e: Exception){

                _getStatus.value = e.localizedMessage
            }
        }
    }*/

    fun postNewGoalPost( goalPost: GoalPost) {
        viewModelScope.launch {
            try {
                val response = goalPostRepository.postGoalPost(goalPost)
            }catch (e: Exception){
                // error handling als new goal niet werkt/ er iets mis loopt
            }
        }
    }

    fun goalBehaald(id:Int){
        viewModelScope.launch {
            try {
                val response = goalPostRepository.checkGoal(id)
                _completedStatus.value = "Doel behaald".toString();

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

    fun shareGoal(id:Int){
        coroutineScope.launch{
            try {
                 val response = goalPostRepository.shareGoal(id)
                 response.await()
                 _shareStatus.value = "Doel gedeeld"
            } catch (e: Exception){
                _shareStatus.value = "Er liep iets mis"
               // _shareStatus.value = e.localizedMessage
            }
        }
    }

    fun deleteGoal(id:Int){
        coroutineScope.launch{
            try {
                val response = goalPostRepository.removeGoal(id)
               val stringResponse= response.await()
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