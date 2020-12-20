package com.example.faithandroid.billboard

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Step
import com.example.faithandroid.skyscraper.GoalPostRepository
import com.example.faithandroid.util.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.await
import java.time.LocalDateTime

/**
 * This is the viewModel for billboard
 *
 * @property status shows the status of the data in the postlist
 * @property properties holds a list of GoalPosts for Billboard
 */
class BillboardViewModel(private val goalPostRepository: GoalPostRepository) : ViewModel() {


    //ERROR STATUS
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status


    private val _properties = MutableLiveData<List<GoalPost>>()

    val properties: LiveData<List<GoalPost>>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getPosts()
    }

    /**
     * gets the posts in Billboard from the backend and puts them into the properties variable
     */
      fun getPosts() {

        coroutineScope.launch {
            var getPropertiesDeferred = goalPostRepository.getBillboardGoals()
            try {
                var listResult = getPropertiesDeferred.await()
                if(listResult.size > 0){
                    _properties.value = listResult
                }
            } catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}