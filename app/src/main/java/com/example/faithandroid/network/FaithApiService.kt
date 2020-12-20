package com.example.faithandroid.network

import com.example.faithandroid.login.data.User
import com.example.faithandroid.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface FaithApiService {

    @Headers("Content-Type: application/json")
    @POST("user/adolescent/login")
    fun loginAdolescent(@Body adolescent: User):
        Call<String>

    @GET("user/adolescent/{email}")
    fun getAdolescent(@Path("email") email: String):
        Call<Adolescent>

    @Headers("Content-Type: application/json")
    @POST("/city/skyscraper/goal")
    suspend fun postGoalPost(@Body goal: GoalPost)

    @Headers("Content-Type: application/json")
    @PUT("city/skyscraper/goal/{goalId}/mark-completed")
    suspend fun checkGoal(@Path("goalId") goalId: Int)

    @GET("city/skyscraper/goal")
    suspend fun getPostsOfSkyScraper(): Response<List<GoalPost>>

    @GET("city/billboard/group")
    fun getGoalsOfGroup(): Call<List<GoalPost>>

    @Headers("Content-Type: application/json")
    @PUT("user/counselor/delete-adolescent")
    fun requestConsultation(): Call<Void>

    @Headers("Content-Type: application/json")
    @PUT("city/skyscraper/goal/{goalId}/share-to-billboard")
    fun shareGoal(@Path("goalId") goalId: Int): Call<String>

    @Headers("Content-Type: application/json")
    @DELETE("city/skyscraper/goal/{id}")
    suspend fun removeGoal(@Path("id") id: Int): Response<Void>

    @GET("city/{placeType}/filtered-post")
    fun getFilteredFromPlace(@Path("placeType") placeType: Int, @Query("postType") postType: Int): Call<List<Post>>

    @GET("city/{placeType}/post")
    suspend fun getPostsOfPlaceByAdolescentEmail(@Path("placeType") placeType: Int): Response<List<Post>>

    @Headers("Content-Type: application/json", "accept: application/json")
    @POST("city/{placeType}/post")
    fun addPostByEmail(@Path("placeType") placeType: Int, @Body post: Post): Call<Void>

    @Headers("Content-Type: application/json", "accept: application/json")
    @PUT("city/{placeType}/post/remove/{postId}")
    suspend fun deletePostByEmail(@Path("placeType") placeType: Int, @Path("postId") postId: Int): Response<Void>

    @Headers("Content-Type: application/json", "accept: application/json")
    @PUT("city/{placeType}/add-existing/{postId}")
    suspend fun addExistingPostToPlace(@Path("postId") postId: Int, @Path("placeType") placeType: Int): Response<Void>

    @Headers("Content-Type: application/json")
    @POST("user/change-password")
    fun changePassword(@Query("ww") ww: String): Call<String>

    @Headers("Content-Type: application/json", "accept: application/json")
    @GET("city/musicroom/playlist")
    fun getPlaylists(): Call<List<Playlist>>

    @Headers("Content-Type: application/json", "accept: application/json")
    @POST("city/musicroom/playlist")
    fun addPlaylist(@Body playlist: Playlist): Call<Void>

    @Headers("Content-Type: application/json", "accept: application/json")
    @DELETE("city/musicroom/playlist/{id}")
    fun deletePlaylist(@Path("id") primaryKey: Int): Call<Void>

    @Headers("Content-Type: application/json", "accept: application/octet-stream")
    @DELETE("city/post/{postId}")
    suspend fun permanentlyDeletePost(@Path("postId") postId: Int): Response<Void>

    @Headers("Content-Type: application/json", "accept: application/json")
    @GET("/avatar")
    fun getAvatar(): Call<Avatar>

    @Headers("Content-Type: application/json", "accept: application/json")
    @PUT("/change-avatar")
    fun postAvatar(@Body avatar: Avatar): Call<Void>
}
