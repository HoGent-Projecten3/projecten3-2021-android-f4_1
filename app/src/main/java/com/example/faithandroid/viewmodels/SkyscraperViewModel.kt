package com.example.faithandroid.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.TextPost

class SkyscraperViewModel : ViewModel() {

    var steps: List<String> = listOf("lijst", "lijst")
    var test = mutableListOf<GoalPost>(
        GoalPost(
        "Hello", "hello", completed = false, steps),
        GoalPost(
            "Hello", "hello", completed = false, steps),
    )
    private var testLiveData = MutableLiveData<List<GoalPost>>(test)

    val testLive: LiveData<List<GoalPost>>
        get() = testLiveData

    fun addGoalPost(goal: GoalPost){
        testLiveData.value = (testLiveData.value)?.plus(goal)
    }

}