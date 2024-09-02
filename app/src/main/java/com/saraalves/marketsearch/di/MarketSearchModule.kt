package com.saraalves.marketsearch.di

import com.google.gson.GsonBuilder
import com.saraalves.marketsearch.data.remote.datasource.SearchDataSource
import com.saraalves.marketsearch.data.remote.datasource.SearchDataSourceImpl
import com.saraalves.marketsearch.data.mapper.SearchResponseToDomainMapper
import com.saraalves.marketsearch.data.remote.api.SearchService
import com.saraalves.marketsearch.data.repository.SearchRepositoryImpl
import com.saraalves.marketsearch.domain.repository.SearchRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



val mapperModule = module {
    single { SearchResponseToDomainMapper() }
}

val dataSourceModule = module {
    single<SearchDataSource> {
        SearchDataSourceImpl(
            searchService = get(),
            searchMapper = get()
        )
    }
}

val repositoryModule = module {
    single<SearchRepository> { SearchRepositoryImpl(get()) }
}

val networkModule = module {
    factory { createRetrofit().create(SearchService::class.java) }
}
private fun createRetrofit(): Retrofit {
    val url = "https://api.mercadolibre.com/"
    val okHttp = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()
    val gson = GsonBuilder().create()
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}