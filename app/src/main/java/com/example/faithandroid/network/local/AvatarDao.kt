package com.example.faithandroid.network.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.faithandroid.models.Avatar
import com.example.faithandroid.models.GoalPost

@Dao
interface AvatarDao {

    @Query("select * from avatar")
    fun getAvatar(): LiveData<Avatar>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(avatar: Avatar)

}