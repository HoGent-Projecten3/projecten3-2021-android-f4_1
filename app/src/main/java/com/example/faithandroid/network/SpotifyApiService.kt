package com.example.faithandroid.network

import com.example.faithandroid.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

// TODO: give url
/*private const val BASE_URL = "https://api.spotify.com/v1/"

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
*/

interface SpotifyApiService {

    @Headers("Content-Type: application/json", "accept: application/json")
    @GET("me")
    fun getUser(): Call<SpotifyUser>

    @Headers("Content-Type: application/json", "accept: application/json")
    @GET("me/playlists")
    suspend fun getPlaylists(): Response<PlaylistWrapper>

    @Headers("Content-Type: application/json", "accept: application/json")
    @GET("playlists/{spotify_cover}/images")
    fun getPlaylistCover(@Path("spotify_cover") cover: String): Call<List<SpotifyCover>>
}

/*object SpotifyApi {
    val retrofitService : SpotifyApiService by lazy {
        retrofit.create(SpotifyApiService::class.java)
    }
}*/
