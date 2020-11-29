package com.example.faithandroid.DI

import com.example.faithandroid.BuildConfig
import com.example.faithandroid.data.local.AppDatabase
import com.example.faithandroid.data.local.PostLocalDataSource
import com.example.faithandroid.data.remote.PostRemoteDataSource
import com.example.faithandroid.network.FaithApiService
import com.example.faithandroid.post.PostRepository
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
    single { provideRetrofit(get(), BuildConfig.BASE_URL) }
    single {
        provideApiService(get())
    }
    single { AppDatabase.getDatabase(androidApplication()).postDao() }
    single { PostRemoteDataSource(get()) }
    single { PostLocalDataSource(get()) }
    single { PostRepository(get(), get()) }

}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())

    .build()

/**
 * Provided a OkHttpClient. In debug version, an interceptor is added
 * as to log the network information which has been received.
 */
private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()


/**
 * Provide the retrofti instance
 */
private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(OkHttpClient().newBuilder().addInterceptor{ chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + AppPreferences.token)
                .build()
            chain.proceed(newRequest)
        }.build())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

/**
 * Provide the API service
 */
private fun provideApiService(retrofit: Retrofit): FaithApiService =
    retrofit.create(FaithApiService::class.java)
