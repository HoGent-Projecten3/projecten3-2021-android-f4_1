package com.example.faithandroid.network

import com.example.faithandroid.models.*
import retrofit2.Call
import retrofit2.http.*

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
