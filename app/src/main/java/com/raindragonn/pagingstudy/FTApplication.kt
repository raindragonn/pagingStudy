package com.raindragonn.pagingstudy

import android.app.Application
import com.raindragonn.pagingstudy.di.appModule
import com.raindragonn.pagingstudy.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PagingApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PagingApplication)
            modules(appModule, networkModule)
        }
    }
}