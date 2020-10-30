package com.example.faithandroid.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//TODO: give url
private const val BASE_URL = "https://growapi.azurewebsites.net/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FaithApiService {
    @GET("Account/GetAdolescentsByCounselorEmail/bob.debouwer1998@gmail.com")
    fun getProperties():
            Call<List<FaithProperty>>
}

object FaithApi {
    val retrofitService : FaithApiService by lazy {
        retrofit.create(FaithApiService::class.java)
    }
}