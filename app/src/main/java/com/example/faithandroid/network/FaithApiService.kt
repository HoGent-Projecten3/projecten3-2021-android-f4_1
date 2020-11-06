package com.example.faithandroid.network

import android.net.Proxy
import android.net.http.HttpResponseCache
import android.util.Log
import com.example.faithandroid.models.GoalPost
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

    @GET("City/GetPostsOfSkyScraperByAdolescentEmail")
    fun getPostsOfSkyScraperByAdolescentEmail(@Query("email") email: String): Deferred<List<GoalPost>>
}

object FaithApi {
    val retrofitService : FaithApiService by lazy {
        retrofit.create(FaithApiService::class.java)
    }
}