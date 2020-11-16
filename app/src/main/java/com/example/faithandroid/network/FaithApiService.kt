package com.example.faithandroid.network

import com.example.faithandroid.login.data.User
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.TextPost
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*
import javax.security.auth.callback.Callback

//TODO: give url
private const val BASE_URL = "https://apigrow.azurewebsites.net/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())

    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface FaithApiService {

    @Headers("Content-Type: application/json")
    @POST("Account/CreateToken")
    fun loginAdolescent(@Body adolescent: User):
           Call<String>


    @GET("Account/GetAdolescent")
    fun getAdolescent(@Query("email") email: String):
           Deferred<Adolescent>

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

    @GET("Account/GetAdolescent")
    fun GetAdolescent(@Query("email")email: String): Deferred<Adolescent>


}

object FaithApi {
    val retrofitService : FaithApiService by lazy {
        retrofit.create(FaithApiService::class.java)
    }
}

