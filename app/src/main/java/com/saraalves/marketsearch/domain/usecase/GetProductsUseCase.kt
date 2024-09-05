package com.saraalves.marketsearch.domain.usecase

import com.saraalves.marketsearch.domain.model.response.ProductItemData
import com.saraalves.marketsearch.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val repository: ProductsRepository) {
    operator fun invoke(id: String): Flow<ProductItemData> = repository.getProducts(id)
}