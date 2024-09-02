package com.saraalves.marketsearch.data.remote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductItemResponse(
    @SerialName("id") val id: String,
    @SerialName("title") val title: String,
    @SerialName("currency_id") val currencyId: String,
    @SerialName("price") val price: Int,
    @SerialName("thumbnail") val thumbnail: String,
)