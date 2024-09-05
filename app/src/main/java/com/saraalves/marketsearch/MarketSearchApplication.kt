package com.saraalves.marketsearch

import android.app.Application
import com.saraalves.marketsearch.di.dataSourceModule
import com.saraalves.marketsearch.di.mapperModule
import com.saraalves.marketsearch.di.networkModule
import com.saraalves.marketsearch.di.repositoryModule
import com.saraalves.marketsearch.di.searchUseCaseModule
import com.saraalves.marketsearch.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarketSearchApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val allModules = listOf(
            networkModule,
            viewModelModule,
            searchUseCaseModule,
            mapperModule,
            dataSourceModule,
            repositoryModule,
        )

        startKoin{
            androidContext(this@MarketSearchApplication)
            modules(allModules)
        }
    }
}