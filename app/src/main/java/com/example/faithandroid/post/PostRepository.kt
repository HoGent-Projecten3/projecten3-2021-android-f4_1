package com.example.faithandroid.post

import com.example.faithandroid.data.local.PostLocalDataSource
import com.example.faithandroid.models.Post
import com.example.faithandroid.network.remote.PostRemoteDataSource
import com.example.faithandroid.util.performDelOperation
import com.example.faithandroid.util.performGetOperation
import java.lang.Exception

/**
 * unused
 */
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

    fun getFilteredFromPlace(placeType: Int, postType: Int) = remoteDataSource.getFilteredFromPlace(placeType, postType)

    fun addPostByEmail(post: Post, placeType: Int) = remoteDataSource.addPostByEmail(post, placeType)

    fun deletePostByEmail(placeType: Int, postId: Int) =
        performDelOperation(
            databaseQuery = {
                when (placeType) {
                    0 -> {
                        localDataSource.deletePostFromBulletinBoard(postId)
                    }
                    1 -> {
                        localDataSource.deletePostFromTreasureChest(postId)
                    }
                    else -> {
                        throw Exception("Er liep onverwachts iets mis")
                    }
                }
            },
            networkCall = { remoteDataSource.deletePostByEmail(placeType, postId) }
        )

    fun addExistingPostToPlace(postId: Int, placeType: Int) = performDelOperation(
        databaseQuery = { when (placeType) {
            0 -> {
                localDataSource.addExistingPostToBulletinBoard(postId)
            }
            1 -> {
                localDataSource.addExistingPostToTreasureChest(postId)
            }
            else -> {
            }
        } },
        networkCall = { remoteDataSource.addExistingPostToPlace(postId, placeType) }
    )

    fun requestConsultation() = remoteDataSource.requestConsultation()

    fun changePassword(ww: String) = remoteDataSource.changePassword(ww)

    fun permanentlyDeletePost(postId: Int) = performDelOperation(
        databaseQuery = { localDataSource.deletePostFromBackpack(postId) },
        networkCall = { remoteDataSource.permanentlyDeletePost(postId) }
    )
}
