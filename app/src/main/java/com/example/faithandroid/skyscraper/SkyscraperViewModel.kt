
package com.example.faithandroid.skyscraper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.util.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.await

/**
 * This is the viewmodel for the skyscraper
 *
 * @property getStatus is the status of whether the goal could be retrieved from the backend
 */

class SkyscraperViewModel(private val goalPostRepository: GoalPostRepository) : ViewModel() {

    private val _status = MutableLiveData<String>()
    val getStatus: LiveData<String>
        get() = _status

    private var test = mutableListOf<GoalPost>()

    var testLive: LiveData<Resource<List<GoalPost>>> = goalPostRepository.getPostsOfSkyScraper()

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun postNewGoalPost(goalPost: GoalPost) {
        viewModelScope.launch {
            try {
                goalPostRepository.postGoalPost(goalPost)
            } catch (e: Exception) {
                // error handling als new goal niet werkt/ er iets mis loopt
                _status.value = e.localizedMessage
            }
        }
    }

    /**
     * checks whether a goal has been completed
     *
     * @param id is the id of the goal to be checked
     */
    fun goalBehaald(id: Int) {
        viewModelScope.launch {
            try {
                val response = goalPostRepository.checkGoal(id)
                _status.value = "Doel behaald"
            } catch (e: HttpException) {
                _status.value = "Er liep iets mis" + e.localizedMessage
            } catch (e: Exception) {
                _status.value = "Er liep iets mis"
            }
        }
    }

    /**
     * shares a goal to the billboard
     *
     * @param id is the id of the goal to be shared
     */
    fun shareGoal(id: Int) {
        coroutineScope.launch {
            try {
                 val response = goalPostRepository.shareGoal(id)
                 response.await()
                _status.value = "Doel gedeeld"
            } catch (e: Exception) {
                _status.value = "Er liep iets mis"
            }
        }
    }

    /**
     * Deletes a goal
     *
     * @param id is the id of the goal to be deleted
     */
    fun deleteGoal(id: Int) {
        coroutineScope.launch {
            try {
                goalPostRepository.removeGoal(id)
                _status.value = "Doel verwijderd"
            } catch (e: Exception) {
                _status.value = "Er liep iets mis"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
