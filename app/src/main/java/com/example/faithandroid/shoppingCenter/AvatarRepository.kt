package com.example.faithandroid.shoppingCenter

import com.example.faithandroid.models.Avatar
import com.example.faithandroid.network.local.AvatarLocalDataSource
import com.example.faithandroid.network.local.GoalPostLocalDataSource
import com.example.faithandroid.network.remote.AvatarRemoteDataSource
import com.example.faithandroid.network.remote.GoalPostRemoteDataSource
import com.example.faithandroid.util.performGetOperation

class AvatarRepository(private val localDataSource: AvatarLocalDataSource, private val remoteDataSource: AvatarRemoteDataSource) {

      fun getAvatar() = performGetOperation(

        databaseQuery = { localDataSource.getAvatar() },
        networkCall = { remoteDataSource.getAvatar() },
        saveCallResult = { localDataSource.saveAvatar(it) }
    )

    //fun getAvatar() = remoteDataSource.getAvatar()


    fun postAvatar(avatar: Avatar) = remoteDataSource.postAvatar(avatar)
}