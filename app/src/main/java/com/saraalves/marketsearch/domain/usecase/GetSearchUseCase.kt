package com.saraalves.marketsearch.domain.usecase

import com.saraalves.marketsearch.domain.model.response.SearchData
import com.saraalves.marketsearch.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class GetSearchUseCase(private val repository: SearchRepository) {
    operator fun invoke(siteId: String, query: String, offset: Int): Flow<SearchData> =
        repository.getSearch(siteId, query, offset)
}