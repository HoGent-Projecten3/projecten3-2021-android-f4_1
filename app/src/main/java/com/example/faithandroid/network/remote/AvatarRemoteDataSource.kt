package com.example.faithandroid.network.remote

import com.example.faithandroid.models.Avatar
import com.example.faithandroid.network.BaseDataSource
import com.example.faithandroid.network.FaithApiService

class AvatarRemoteDataSource(private val apiService: FaithApiService) : BaseDataSource() {

    suspend fun getAvatar() = getObjectResult { apiService.getAvatar() }

    fun postAvatar(avatar: Avatar) =  apiService.postAvatar(avatar)
}