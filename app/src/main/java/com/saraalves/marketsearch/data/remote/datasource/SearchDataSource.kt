package com.saraalves.marketsearch.data.remote.datasource

import com.saraalves.marketsearch.domain.model.response.SearchData
import kotlinx.coroutines.flow.Flow

interface SearchDataSource {
    fun getSearch(siteId: String, query: String?, offset: Int): Flow<SearchData>
}