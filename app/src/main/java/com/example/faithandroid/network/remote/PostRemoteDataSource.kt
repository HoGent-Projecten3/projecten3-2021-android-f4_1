package com.example.faithandroid.network.remote

import com.example.faithandroid.models.Post
import com.example.faithandroid.network.BaseDataSource
import com.example.faithandroid.network.FaithApiService

class PostRemoteDataSource(private val apiService: FaithApiService) : BaseDataSource() {

    suspend fun getPostsOfPlaceByAdolescentEmail(placeType: Int) = getResult { apiService.getPostsOfPlaceByAdolescentEmail(placeType) }

    fun getFilteredFromPlace(placeType: Int, postType: Int) = apiService.getFilteredFromPlace(placeType, postType)

    fun addPostByEmail(post: Post, placeType: Int) = apiService.addPostByEmail(placeType, post)

    suspend fun deletePostByEmail(placeType: Int, postId: Int) = apiService.deletePostByEmail(placeType, postId)

    suspend fun addExistingPostToPlace(postId: Int, placeType: Int) = apiService.addExistingPostToPlace(postId, placeType)

    fun requestConsultation() = apiService.requestConsultation()

    suspend fun permanentlyDeletePost(postId: Int) = apiService.permanentlyDeletePost(postId)

    fun changePassword(ww: String) = apiService.changePassword(ww)
}
