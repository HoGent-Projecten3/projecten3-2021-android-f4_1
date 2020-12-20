package com.example.faithandroid.post

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.faithandroid.data.local.PostLocalDataSource
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Post
import com.example.faithandroid.network.remote.PostRemoteDataSource
import com.example.faithandroid.util.performDelOperation
import com.example.faithandroid.util.performFilterOperation
import com.example.faithandroid.util.performGetOperation
import retrofit2.Call
import retrofit2.Response
import retrofit2.await
import retrofit2.http.Path
import java.lang.Exception

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

    //fun getPostsOfPlaceByAdolescentEmail(placeType: Int) = remoteDataSource.getPostsOfPlaceByAdolescentEmail(placeType)

     /*fun getFilteredFromPlace(placeType: Int,postType: Int) =

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
        )*/

    fun getFilteredFromPlace(placeType: Int,postType: Int) = performFilterOperation {  when(placeType)
    {
        0 -> {
            Log.d("filteren", "posttype: $postType placetype: $placeType")
            localDataSource.getFilteredFromBulletinboard(postType)
        }
        1 -> {
            Log.d("filteren", "posttype: $postType placetype: $placeType")
            localDataSource.getFilteredFromTreasureChest(postType)
        }
        else -> {
            Log.d("filteren", "posttype: $postType placetype: $placeType")
            localDataSource.getFilteredFromBackPack(postType)

        }        }
    }

    fun addPostByEmail(post: Post, placeType: Int) = remoteDataSource.addPostByEmail(post,placeType)

    fun deletePostByEmail(placeType: Int,postId: Int) =
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
            networkCall = {remoteDataSource.deletePostByEmail(placeType,postId)}
        )

    //fun deletePostByEmail(placeType: Int,postId: Int) = remoteDataSource.deletePostByEmail(placeType,postId)


    fun addExistingPostToPlace(postId: Int,placeType: Int) = remoteDataSource.addExistingPostToPlace(postId,placeType)

    fun requestConsultation() = remoteDataSource.requestConsultation()

    fun changePassword(ww: String) = remoteDataSource.changePassword(ww)

    fun permanentlyDeletePost(postId: Int) = performDelOperation(
        databaseQuery = {localDataSource.deletePostFromBackpack(postId)},
        networkCall = {remoteDataSource.permanentlyDeletePost(postId)}
    )


}