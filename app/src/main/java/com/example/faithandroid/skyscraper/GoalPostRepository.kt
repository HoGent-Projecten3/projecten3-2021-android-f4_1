package com.example.faithandroid.skyscraper

import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.network.local.GoalPostLocalDataSource
import com.example.faithandroid.network.remote.GoalPostRemoteDataSource
import com.example.faithandroid.util.performDelOperation
import com.example.faithandroid.util.performGetOperation

class GoalPostRepository(private val localDataSource: GoalPostLocalDataSource, private val remoteDataSource: GoalPostRemoteDataSource) {

    fun getPostsOfSkyScraper() = performGetOperation(

        databaseQuery = { localDataSource.getPostsOfSkyScraper() },
        networkCall = { remoteDataSource.getPostsOfSkyScraper() },
        saveCallResult = { localDataSource.saveGoalposts(it) }
    )

     /*fun getBillboardGoals() = performGetOperation(

         databaseQuery = { localDataSource.getBillboardGoals() },
         networkCall = { remoteDataSource.getBillboardGoals() },
         saveCallResult = { localDataSource.saveGoalBill(it) }
     )*/

    fun getBillboardGoals() = remoteDataSource.getBillboardGoals()

    suspend fun postGoalPost(goal: GoalPost) = remoteDataSource.postGoalPost(goal)

    suspend fun checkGoal(id: Int) = remoteDataSource.checkGoal(id)

    fun shareGoal(id: Int) = remoteDataSource.shareGoal(id)

    fun removeGoal(id: Int) =
        performDelOperation(
            databaseQuery = { localDataSource.removeGoal(id) },
            networkCall = { remoteDataSource.removeGoal(id) }
        )
}
