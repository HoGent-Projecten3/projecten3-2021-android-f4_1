package com.example.faithandroid.network.local

import com.example.faithandroid.models.GoalPost

class GoalPostLocalDataSource(private val goalPostDao: GoalPostDao) {


    fun getPostsOfSkyScraper() = goalPostDao.getPostsOfSkyScraper()

    fun getBillboardGoals() = goalPostDao.getBillboardGoals()

    //fun postGoalPost(goal : GoalPost) = goalPostDao.postGoalPost(goal)

    //fun checkGoal(id: Int) = goalPostDao.checkGoal(id)

    //fun shareGoal(id : Int) = goalPostDao.shareGoal(id)

    //fun removeGoal(id: Int) = goalPostDao.removeGoal(id)

    fun saveGoalposts(list: List<GoalPost>) = goalPostDao.insertAll(list)
}