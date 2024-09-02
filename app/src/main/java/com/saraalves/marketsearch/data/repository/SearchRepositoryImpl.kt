package com.saraalves.marketsearch.data.repository

import com.saraalves.marketsearch.data.remote.datasource.SearchDataSource
import com.saraalves.marketsearch.domain.model.response.SearchData
import com.saraalves.marketsearch.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepositoryImpl(private val searchDataSource: SearchDataSource) : SearchRepository {
    override fun getSearch(
        siteId: String,
        query: String,
        offset: Int
    ): Flow<SearchData> = flow {
        getSearchData(siteId, query, offset).collect { remoteList ->
            emit(remoteList)
        }
    }

    private fun getSearchData(siteId: String, query: String, offset: Int): Flow<SearchData> =
        searchDataSource.getSearch(siteId, query, offset)

}