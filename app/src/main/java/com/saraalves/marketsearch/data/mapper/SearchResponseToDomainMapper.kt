package com.saraalves.marketsearch.data.mapper

import com.saraalves.marketsearch.data.remote.model.response.ProductItemResponse
import com.saraalves.marketsearch.data.remote.model.response.SearchResponse
import com.saraalves.marketsearch.domain.model.response.ProductItemData
import com.saraalves.marketsearch.domain.model.response.SearchData


class SearchResponseToDomainMapper : Mapper<SearchResponse, SearchData> {
    override fun map(source: SearchResponse): SearchData {
        return SearchData(
            results = source.results.map { it.mapToProductsItem() }
        )
    }
}

fun ProductItemResponse.mapToProductsItem(): ProductItemData {
    return ProductItemData(
        id = id,
        title = title,
        currencyId = currencyId,
        price = price,
        thumbnail = thumbnail
    )
}