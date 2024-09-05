package com.saraalves.marketsearch.data.remote.datasource.products

import com.saraalves.marketsearch.domain.model.response.ProductItemData
import kotlinx.coroutines.flow.Flow

interface ProductsDataSource {
    fun getProducts(id: String): Flow<ProductItemData>
}