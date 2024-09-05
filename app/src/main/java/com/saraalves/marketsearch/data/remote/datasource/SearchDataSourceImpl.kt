package com.saraalves.marketsearch.data.remote.datasource

import com.saraalves.marketsearch.data.extensions.parseHttpError
import com.saraalves.marketsearch.data.mapper.SearchResponseToDomainMapper
import com.saraalves.marketsearch.data.remote.api.SearchService
import com.saraalves.marketsearch.domain.model.response.SearchData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchDataSourceImpl(
    private val searchService: SearchService,
    private val searchMapper: SearchResponseToDomainMapper
) : SearchDataSource {
    override fun getSearch(siteId: String, query: String?, offset: Int): Flow<SearchData> {
        return flow {
            emit(searchMapper.map(searchService.getResultsSearch(siteId, query, offset)))
        }.parseHttpError()
    }
}