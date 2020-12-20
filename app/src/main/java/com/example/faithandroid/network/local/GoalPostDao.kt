package com.example.faithandroid.network.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.faithandroid.models.GoalPost
import kotlinx.coroutines.selects.select


@Dao
interface GoalPostDao {

    @Query("select * from goalPosts")
    fun getPostsOfSkyScraper(): LiveData<List<GoalPost>>

    /*@Transaction
    @Query("select * from goalPosts")
    fun getGoalsWithSteps(): List<GoalWithSteps>*/

    @Query("select * from goalPosts where shared == 1")
    fun getBillboardGoals(): LiveData<List<GoalPost>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllBill(list: List<GoalPost>)

    @Query("delete from goalPosts where id == :goalPostId")
    fun removeGoal(goalPostId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<GoalPost>)
}