package com.example.faithandroid.billboard

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Step
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class BillboardViewModel : ViewModel() {

    //ERROR STATUS
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    @RequiresApi(Build.VERSION_CODES.O)
    val mockData = mutableListOf<GoalPost>(
        GoalPost(0, "Huiswerk maken", "Mijn huiwerk maken voor Nederlands, Wiskunde & Geschiedenis", true, listOf<Step>(Step(0, "step")), "03/12/2020") ,
        GoalPost(0, "Kamer restylen", "Kamer een makeover geven in de stijl van New York dus met schilderen, posters ophangen en eventueel meubels verplaatsen enzo", true, listOf<Step>(Step(0, "step")), "29/12/2020")
// LocalDateTime.of(2020, 7, 3, 12, 0 ))
    )

    private val _properties = MutableLiveData<List<GoalPost>>()

    val properties: LiveData<List<GoalPost>>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getPosts()
    }

    public fun getPosts() {
        coroutineScope.launch {
            var getPropertiesDeferred = FaithApi.retrofitService.getBillboardGoals()
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