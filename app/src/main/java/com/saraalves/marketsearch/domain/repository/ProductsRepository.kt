package com.saraalves.marketsearch.domain.repository

import com.saraalves.marketsearch.domain.model.response.ProductItemData
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    fun getProducts(id: String): Flow<ProductItemData>
}