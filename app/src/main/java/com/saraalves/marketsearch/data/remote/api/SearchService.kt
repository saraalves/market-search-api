package com.saraalves.marketsearch.data.remote.api

import com.saraalves.marketsearch.data.remote.model.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SearchService {
    @GET("sites/{site_id}/search")
    suspend fun getResultsSearch(
        @Path("site_id") siteId: String,
        @Query("q") query: String,
        @Query("offset") offset: Int
    ): SearchResponse
}