package com.example.faithandroid.network


import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.faithandroid.login.data.User
import com.example.faithandroid.models.Adolescent

import com.example.faithandroid.PlaceType
import com.example.faithandroid.PostType

import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Post

import com.google.android.material.internal.ContextUtils.getActivity

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*
import javax.security.auth.callback.Callback

//TODO: give url
private const val BASE_URL = "https://apigrow.azurewebsites.net/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())

    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(OkHttpClient().newBuilder().addInterceptor{ chain ->
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer " + AppPreferences.token)
            .build()
        chain.proceed(newRequest)
    }
    .build())
    .baseUrl(BASE_URL)
    .build()


interface FaithApiService {

    @Headers("Content-Type: application/json")
    @POST("user/adolescent/login")
    fun loginAdolescent(@Body adolescent: User):
           Call<String>


    @GET("user/adolescent/{email}")
    fun getAdolescent(@Path("email") email: String):
           Deferred<Adolescent>

    @Headers("Content-Type: application/json")
    @POST("City/AddGoalByEmail")
    suspend fun postGoalPost(@Body goal: GoalPost, @Query("email") email:String)

  
    @Headers("Content-Type: application/json")
    @PUT("City/MarkGoalAsCompleted")
    suspend fun checkGoal(@Query("email") email: String, @Query("id") id: Int)

  
    @GET("City/GetPostsOfSkyScraperByAdolescentEmail")
    fun getPostsOfSkyScraperByAdolescentEmail(@Query("email") email: String): Deferred<List<GoalPost>>


    @GET("City/GetPostsOfBulletinBoardByAdolescentEmail")
    fun getPostsOfBulletinBoardByAdolescentEmail(@Query("email") email: String):
        Deferred<List<Post>>

    @GET("City/GetPostsOfBackpackByAdolescentEmail")
    fun getPostsOfBackpackByAdolescentEmail(@Query("email") email: String):
            Deferred<List<Post>>

    @GET("City/GetPostsOfTreasureChestByAdolescentEmail")
    fun getPostsOfTreasureChestByAdolescentEmail(@Query("email") email: String):
            Deferred<List<Post>>

    @GET("City/GetBillboardGoalsByAdolescentMail")
    fun getBillboardGoalsByAdolescentEmail(@Query("email") email: String): Deferred<List<GoalPost>>


    @Headers("Content-Type: application/json")
    @PUT("Account/PostConsultationRequest")
    fun requestConsultation(@Query("email") email: String): Call<Void>

    @PUT("City/ShareGoalWithBillboard")
    fun shareGoal(@Query("email") email: String, @Query("id") id: Int)


    @POST("City/DeleteGoalByEmail")
    fun removeGoal(@Query("id") id: Int, @Query("email") email: String)

    @GET("City/GetFilteredPostsFromPlace")
    fun getFilteredFromPlace(@Query("placeType") placeType: Int, @Query("postType") postType: Int, @Query("email") email: String): Call<List<Post>>


    @GET("city/{placeType}/post")
    fun getPostsOfPlaceByAdolescentEmail(@Path("placeType") placeType: Int): Call<List<Post>>

    @Headers("Content-Type: application/json", "accept: application/json")
    @POST("city/{placeType}/post")
    fun addPostByEmail(@Body post: Post, @Path("placeType") placeType: Int): Call<Void>

    @Headers("Content-Type: application/json", "accept: application/json")
    @PUT("City/DeletePostByEmail")
    fun deletePostByEmail(@Query("id") id: Int, @Query("email") email: String, @Query("placeType") placeType: Int): Call<Void>

    @Headers("Content-Type: application/json", "accept: application/json")
    @PUT("City/AddExistingPostToPlace")
    fun addExistingPostToPlace(@Query("postId") id: Int, @Query("placeType")placeType: Int): Call<Void>

}

object FaithApi {
    val retrofitService : FaithApiService by lazy {
        retrofit.create(FaithApiService::class.java)
    }
}

