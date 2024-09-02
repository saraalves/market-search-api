package com.saraalves.marketsearch.data.remote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("results") val results: List<ProductItemResponse>
)