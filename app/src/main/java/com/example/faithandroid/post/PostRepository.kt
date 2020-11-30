package com.example.faithandroid.post

import com.example.faithandroid.data.local.PostLocalDataSource
import com.example.faithandroid.data.remote.PostRemoteDataSource
import com.example.faithandroid.network.FaithApi
import com.example.nativeapps.util.performGetOperation

class PostRepository(val localDataSource: PostLocalDataSource, val remoteDataSource: PostRemoteDataSource) {

    fun getPostsOfPlaceByAdolescentEmail(placeType: Int) = performGetOperation(

        databaseQuery = { localDataSource.getPostsOfPlaceByAdolescentEmail(placeType) },
        networkCall = { remoteDataSource.getPostsOfPlaceByAdolescentEmail(placeType) },
        saveCallResult = { localDataSource.savePosts(it) }
    )
}