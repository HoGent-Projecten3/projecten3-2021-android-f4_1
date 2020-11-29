package com.example.faithandroid.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.faithandroid.models.Post

@Dao
interface PostDao {

    @Query("select * from posts where postType =:placeType") //houden placetype niet bij
    fun getPostsOfPlaceByAdolescentEmail(placeType: Int): LiveData<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Post>)
}