package com.example.faithandroid.post

import com.example.faithandroid.data.local.PostLocalDataSource
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Post
import com.example.faithandroid.network.remote.PostRemoteDataSource
import com.example.faithandroid.util.performGetOperation
import retrofit2.http.Path

class PostRepository(private val localDataSource: PostLocalDataSource, private val remoteDataSource: PostRemoteDataSource) {

     fun getPostsOfPlaceByAdolescentEmail(placeType: Int) =

        performGetOperation(
            databaseQuery = {
                when (placeType) {
                    0 -> {
                        localDataSource.getPostsOfBulletinboard()
                    }
                    1 -> {
                        localDataSource.getPostsOfTreasureChest()
                    }
                    else -> {
                        localDataSource.getPostsOfBackpack()
                    }
                }
            },
            networkCall = { remoteDataSource.getPostsOfPlaceByAdolescentEmail(placeType) },
            saveCallResult = { localDataSource.savePosts(it) }
        )

     fun getFilteredFromPlace(placeType: Int,postType: Int) =

        performGetOperation(
            databaseQuery = {
                when (placeType) {
                    0 -> {
                        localDataSource.getFilteredFromBulletinboard(postType)
                    }
                    1 -> {
                        localDataSource.getFilteredFromTreasureChest(postType)
                    }
                    else -> {
                        localDataSource.getFilteredFromBackPack(postType)
                    }
                }
            },
            networkCall = { remoteDataSource.getFilteredFromPlace(placeType, postType) },
            saveCallResult = { localDataSource.savePosts(it) }
        )


    fun addPostByEmail(post: Post, placeType: Int) = remoteDataSource.addPostByEmail(post,placeType)

    fun deletePostByEmail(placeType: Int,postId: Int) =
        performGetOperation(
            databaseQuery = {remoteDataSource.deletePostByEmail(postId)},
            networkCall = {remoteDataSource.deletePostByEmail(placeType,postId)},
            saveCallResult = {}
        )


    fun addExistingPostToPlace(postId: Int,placeType: Int) = remoteDataSource.addExistingPostToPlace(postId,placeType)

    fun requestConsultation() = remoteDataSource.requestConsultation()

    fun changePassword(ww: String) = remoteDataSource.changePassword(ww)

    fun permanentlyDeletePost(postId: Int) = remoteDataSource.permanentlyDeletePost(postId)


}