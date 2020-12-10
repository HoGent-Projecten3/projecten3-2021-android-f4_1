package com.example.faithandroid.network


import com.example.faithandroid.login.data.User
import com.example.faithandroid.models.Adolescent

import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Playlist
import com.example.faithandroid.models.Post


import com.google.android.material.internal.ContextUtils.getActivity



import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
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
    suspend fun checkGoal(@Path("goalId") goalId : Int)

    @GET("city/skyscraper/goal")
    suspend fun getPostsOfSkyScraper(): Response<List<GoalPost>>

    @GET("city/billboard/goal")
    suspend fun getBillboardGoals(): Response<List<GoalPost>>

    @Headers("Content-Type: application/json")
    @PUT("user/counselor/delete-adolescent")
    fun requestConsultation(): Call<Void>

    @Headers("Content-Type: application/json")
    @PUT("city/skyscraper/goal/{goalId}/share-to-billboard")
    fun shareGoal(@Path("goalId") goalId: Int): Call<String>

    @Headers("Content-Type: application/json")
    @DELETE("city/skyscraper/goal/{id}")
    fun removeGoal(@Path("id") id: Int): Call<String>

    @GET("city/{placeType}/filtered-post")
    suspend fun getFilteredFromPlace(@Path("placeType") placeType: Int, @Query("postType") postType: Int): Response<List<Post>>

    @GET("city/{placeType}/post")
    suspend fun getPostsOfPlaceByAdolescentEmail(@Path("placeType") placeType: Int): Response<List<Post>>

    @Headers("Content-Type: application/json", "accept: application/json")
    @POST("city/{placeType}/post")

    fun addPostByEmail(@Path("placeType") placeType: Int, @Body post: Post): Call<Void>

    @Headers("Content-Type: application/json", "accept: application/json")
    @PUT("city/{placeType}/post/remove/{postId}")
    fun deletePostByEmail(@Path("placeType") placeType: Int, @Path("postId") postId: Int): Call<Void>

    @Headers("Content-Type: application/json", "accept: application/json")
    @PUT("city/{placeType}/add-existing/{postId}")
    fun addExistingPostToPlace(@Path("placeType") placeType: Int, @Path("postId") postId: Int): Call<Void>


    @Headers("Content-Type: application/json")
    @POST("user/change-password")
    fun changepassword(@Query("ww") ww: String) : Call<String>


    @Headers("Content-Type: application/json", "accept: application/json")
    @GET("city/musicroom/playlist")
    suspend fun getPlaylists(): Response<List<Playlist>>

    @Headers("Content-Type: application/json", "accept: application/json")
    @POST("city/musicroom/playlist")
    fun addPlaylist(@Body playlist: Playlist): Call<Void>

    @Headers("Content-Type: application/json", "accept: application/json")
    @DELETE("city/musicroom/playlist/{id}")
    fun deletePlaylist(@Path("id") primaryKey: Int): Call<Void>


    @Headers("Content-Type: application/json", "accept: application/octet-stream")
    @DELETE("city/post/{postId}")
    fun permanentlyDeletePost(@Path("postId") postId: Int):Call<Void>


}



