package com.example.faithandroid.DI

import com.example.faithandroid.BuildConfig
import com.example.faithandroid.data.local.PostLocalDataSource
import com.example.faithandroid.login.data.LoginDataSource
import com.example.faithandroid.login.data.LoginRepository
import com.example.faithandroid.musicRoom.SpotifyRepository
import com.example.faithandroid.network.FaithApiService
import com.example.faithandroid.network.SpotifyApiService
import com.example.faithandroid.network.local.AppDatabase
import com.example.faithandroid.network.local.AvatarLocalDataSource
import com.example.faithandroid.network.local.GoalPostLocalDataSource
import com.example.faithandroid.network.local.SpotifyLocalDataSource
import com.example.faithandroid.network.remote.AvatarRemoteDataSource
import com.example.faithandroid.network.remote.GoalPostRemoteDataSource
import com.example.faithandroid.network.remote.PostRemoteDataSource
import com.example.faithandroid.network.remote.SpotifyRemoteDataSource
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.shoppingCenter.AvatarRepository
import com.example.faithandroid.skyscraper.GoalPostRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


val networkModule = module {
    single { provideOkHttpClient() }

    single { provideRetrofitFaith(get(),"https://apigrow.azurewebsites.net") }
    single { provideApiService(get()) }

    //single { provideRetrofitSpotify(get(),"https://api.spotify.com/v1/") }
    single { provideSpotifyApiService(provideRetrofitSpotify(get(),"https://api.spotify.com/v1/")) }

    single { AppDatabase.getDatabase(androidApplication()).postDao() }
    single { AppDatabase.getDatabase(androidApplication()).spotifyDao() }
    single { AppDatabase.getDatabase(androidApplication()).goalPostDao() }
    single { AppDatabase.getDatabase(androidApplication()).avatarDao() }

    single { PostRemoteDataSource(get()) }
    single { PostLocalDataSource(get()) }
    single { PostRepository(get(), get()) }

    single { GoalPostRemoteDataSource(get()) }
    single { GoalPostLocalDataSource(get()) }
    single { GoalPostRepository(get(), get()) }

    single { SpotifyRemoteDataSource(get(),get()) }
    single { SpotifyLocalDataSource(get()) }
    single { SpotifyRepository(get(),get()) }

    single { AvatarRemoteDataSource(get()) }
    single { AvatarLocalDataSource(get()) }
    single { AvatarRepository(get(),get()) }


    single { LoginDataSource(get()) }
    single { LoginRepository(get()) }

}

    val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())

    .build()


private fun provideOkHttpClient() =
    if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    private fun provideRetrofitFaith(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(OkHttpClient().newBuilder().addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + AppPreferences.token)
                .build()
            chain.proceed(newRequest)
        }
            .build())
        .baseUrl(BASE_URL)
        .build()

    private fun provideRetrofitSpotify(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(OkHttpClient().newBuilder().addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + AppPreferences.spotifyToken)
                .build()
            chain.proceed(newRequest)
        }
            .build())
        .baseUrl(BASE_URL)
        .build()

private fun provideApiService(retrofit: Retrofit) : FaithApiService =
    retrofit.create(FaithApiService::class.java)

private fun provideSpotifyApiService(retrofit : Retrofit) : SpotifyApiService =
    retrofit.create(SpotifyApiService::class.java)