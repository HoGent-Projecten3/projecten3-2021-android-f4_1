package com.example.faithandroid

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

//TODO: give url
private const val BASE_URL = "https://10.0.2.2:5001/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface FaithApiService {
    @GET("Account/GetAdolescentsByCounselorEmail/bob.debouwer1998@gmail.com")
    fun getProperties():
            Call<String>
}

object FaithApi {
    val retrofitService : FaithApiService by lazy {
        retrofit.create(FaithApiService::class.java)
    }
}

//GetAdolescentsByCounselorEmail/bob.debouwer1998@gmail.com