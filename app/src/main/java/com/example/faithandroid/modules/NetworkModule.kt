package com.example.faithandroid.modules

import com.example.faithandroid.login.data.LoginDataSource
import com.example.faithandroid.login.data.LoginRepository
import com.example.faithandroid.network.local.AppDatabase
import com.example.faithandroid.network.local.GoalPostLocalDataSource
import com.example.faithandroid.network.remote.GoalPostRemoteDataSource
import com.example.faithandroid.skyscraper.GoalPostRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val networkModule = module {
    /*single { provideOkHttpClient() }
    single { provideRetrofit(get(), BuildConfig.BASE_URL) }
    single {
        provideApiService(get())
    }*/
    single { AppDatabase.getDatabase(androidApplication()).goalPostDao() }
    single { GoalPostRemoteDataSource(get()) }
    single { GoalPostLocalDataSource(get()) }
    single { GoalPostRepository(get(), get()) }
    single { LoginDataSource() }
    single { LoginRepository(get()) }

}
