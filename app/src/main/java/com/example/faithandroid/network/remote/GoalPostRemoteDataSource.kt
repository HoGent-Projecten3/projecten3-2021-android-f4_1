package com.example.faithandroid.network.remote

import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.network.BaseDataSource
import com.example.faithandroid.network.FaithApiService

class GoalPostRemoteDataSource(private val apiService: FaithApiService): BaseDataSource() {

    suspend fun getPostsOfSkyScraper() = getResult { apiService.getPostsOfSkyScraper()}

    suspend fun getBillboardGoals() = getResult {apiService.getGoalsOfGroup() }

    suspend fun postGoalPost(goal : GoalPost) = apiService.postGoalPost(goal)

    suspend fun checkGoal(id: Int) = apiService.checkGoal(id)

    fun shareGoal(id : Int) = apiService.shareGoal(id)

    fun removeGoal(id: Int) = apiService.removeGoal(id)
}