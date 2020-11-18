package com.example.faithandroid.network

import android.net.Proxy
import android.net.http.HttpResponseCache
import android.util.Log
import com.example.faithandroid.PlaceType
import com.example.faithandroid.PostType
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.TextPost
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

//TODO: give url
private const val BASE_URL = "https://growapi.azurewebsites.net/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface FaithApiService {

    @GET("Account/GetAdolescentsByCounselorEmail/bob.debouwer1998@gmail.com")
    fun getProperties():
            Deferred<List<FaithProperty>>

    @Headers("Content-Type: application/json")
    @POST("City/AddPostByEmail")
    fun postPost(@Body post: TextPost, @Query("email") email: String):
            Call<Void>

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

    @GET("City/GetBillboardGoalsByAdolescentEmail")
    fun getBillboardGoalsByAdolescentEmail(@Query("email") email: String): Deferred<List<GoalPost>>


    @Headers("Content-Type: application/json")
    @PUT("Account/PostConsultationRequest")
    fun requestConsultation(@Query("email") email: String): Call<Void>

    @PUT("City/ShareGoalWithBillboard")
    fun shareGoal(@Query("email") email: String, @Query("id") id: Int)


    @POST("City/DeleteGoalByEmail")
    fun removeGoal(@Query("id") id: Int, @Query("email") email: String)


    @GET("")
    fun GetFilteredFromPlace(@Query("PlaceType") placeType: PlaceType, @Query("PostType") postType: PostType, @Query("email") email: String)

}

object FaithApi {
    val retrofitService : FaithApiService by lazy {
        retrofit.create(FaithApiService::class.java)
    }
}

