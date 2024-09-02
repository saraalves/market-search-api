package com.saraalves.marketsearch.domain.model.response

data class ProductItemData(
    val id: String,
    val title: String,
    val currencyId: String,
    val price: Int,
    val thumbnail: String,
)