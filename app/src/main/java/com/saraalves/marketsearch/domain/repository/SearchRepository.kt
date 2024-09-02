package com.saraalves.marketsearch.domain.repository

import com.saraalves.marketsearch.domain.model.response.SearchData
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun getSearch(siteId: String, query: String, offset: Int): Flow<SearchData>
}