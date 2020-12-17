package com.example.faithandroid.network


import com.example.faithandroid.login.data.User
import com.example.faithandroid.models.*


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
           Call<Adolescent>

    @Headers("Content-Type: application/json")
    @POST("/city/skyscraper/goal")
    suspend fun postGoalPost(@Body goal: GoalPost)

    @Headers("Content-Type: application/json")
    @PUT("city/skyscraper/goal/{goalId}/mark-completed")
    suspend fun checkGoal(@Path("goalId") goalId : Int)

    @GET("city/skyscraper/goal")
    fun getPostsOfSkyScraper(): Deferred<List<GoalPost>>

    @GET("city/billboard/group")
    fun getBillboardGoals(): Deferred<List<GoalPost>>

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
    fun getFilteredFromPlace(@Path("placeType") placeType: Int, @Query("postType") postType: Int): Call<List<Post>>

    @GET("city/{placeType}/post")
    fun getPostsOfPlaceByAdolescentEmail(@Path("placeType") placeType: Int): Call<List<Post>>

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
    fun getPlaylists(): Call<List<Playlist>>

    @Headers("Content-Type: application/json", "accept: application/json")
    @POST("city/musicroom/playlist")
    fun addPlaylist(@Body playlist: Playlist): Call<Void>

    @Headers("Content-Type: application/json", "accept: application/json")
    @DELETE("city/musicroom/playlist/{id}")
    fun deletePlaylist(@Path("id") primaryKey: Int): Call<Void>


    @Headers("Content-Type: application/json", "accept: application/octet-stream")
    @DELETE("city/post/{postId}")
    fun permanentlyDeletePost(@Path("postId") postId: Int):Call<Void>

    @Headers("Content-Type: application/json", "accept: application/json")
    @GET("/avatar")
    fun getAvatar(): Call<Avatar>

    @Headers("Content-Type: application/json", "accept: application/json")
    @PUT("/change-avatar")
    fun postAvatar(@Body avatar: Avatar): Call<Void>
}

object FaithApi {
    val retrofitService : FaithApiService by lazy {
        retrofit.create(FaithApiService::class.java)
    }
}

