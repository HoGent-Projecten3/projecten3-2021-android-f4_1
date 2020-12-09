package com.example.faithandroid

import android.app.Application
import com.example.faithandroid.modules.networkModule
import com.example.faithandroid.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class GROWApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GROWApplication)
            modules(
                networkModule,
                viewModelModule
            )
        }
    }
}