package com.example.faithandroid.network.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.faithandroid.models.Post

@Dao
interface PostDao {

    @Query("select * from posts where bulletinBoard == 1")
    fun getPostsOfBulletinBoard(): LiveData<List<Post>>

    @Query("select * from posts where treasureChest == 1")
    fun getPostsOfTreasureChest(): LiveData<List<Post>>

    @Query("select * from posts")
    fun getPostsOfBackpack(): LiveData<List<Post>>

    @Query("select * from posts where postType ==:postType and bulletinBoard == 1")
    fun getFilteredFromBulletinboard(postType: Int) : LiveData<List<Post>>

    @Query("select * from posts where postType ==:postType and treasureChest == 1")
    fun getFilteredFromTreasureChest(postType: Int) : LiveData<List<Post>>

    @Query("select * from posts where postType ==:postType")
    fun getFilteredFromBackPack(postType: Int) : LiveData<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Post>)
}
