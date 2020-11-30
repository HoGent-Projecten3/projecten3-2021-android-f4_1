package com.example.faithandroid.data.remote

import AppPreferences
import com.example.faithandroid.PlaceType
import com.example.faithandroid.data.BaseDataSource
import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.network.FaithApiService

class PostRemoteDataSource(private val apiService: FaithApiService) : BaseDataSource() {

    suspend fun getPostsOfPlaceByAdolescentEmail(placeType: Int) = getResult {apiService.getPostsOfPlaceByAdolescentEmail(placeType,"Bearer " + AppPreferences.token!!) }
}