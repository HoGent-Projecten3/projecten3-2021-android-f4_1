package com.example.faithandroid.network

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.faithandroid.login.data.User

import com.example.faithandroid.PlaceType
import com.example.faithandroid.PostType
import com.example.faithandroid.models.*

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
private const val BASE_URL = "https://api.spotify.com/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(OkHttpClient().newBuilder().addInterceptor{ chain ->
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer " + AppPreferences.spotifyToken)
            .build()
        chain.proceed(newRequest)
    }
        .build())
    .baseUrl(BASE_URL)
    .build()


interface SpotifyApiService {

    @Headers("Content-Type: application/json", "accept: application/json")
    @GET("me")
    fun getUser(): Call<SpotifyUser>

    @Headers("Content-Type: application/json", "accept: application/json")
    @GET("me/playlists")
    fun getPlaylists(): Call<PlaylistWrapper>


    @Headers("Content-Type: application/json", "accept: application/json")
    @GET("playlists/{spotify_cover}/images")
    fun getPlaylistCover(@Path("spotify_cover") cover: String): Call<List<SpotifyCover>>

}

object SpotifyApi {
    val retrofitService : SpotifyApiService by lazy {
        retrofit.create(SpotifyApiService::class.java)
    }
}

