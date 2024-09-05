package com.saraalves.marketsearch.data.repository

import android.os.RemoteException
import com.saraalves.marketsearch.data.remote.datasource.SearchDataSource
import com.saraalves.marketsearch.domain.model.response.SearchData
import com.saraalves.marketsearch.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import kotlin.jvm.Throws

class SearchRepositoryImpl(private val searchDataSource: SearchDataSource) : SearchRepository {
    override fun getSearch(
        siteId: String,
        query: String?,
        offset: Int
    ): Flow<SearchData> = flow {
        try {
            getSearchData(siteId, query, offset).collect { remoteList ->
                emit(remoteList)
            }
        } catch (ex: HttpException) {
            throw RemoteException()
        }

    }

    private fun getSearchData(siteId: String, query: String?, offset: Int): Flow<SearchData> =
        searchDataSource.getSearch(siteId, query, offset)

}