package com.saraalves.marketsearch.data.remote.datasource

import com.saraalves.marketsearch.data.extensions.parseHttpError
import com.saraalves.marketsearch.data.mapper.mapToProductsItem
import com.saraalves.marketsearch.data.remote.api.ProductsService
import com.saraalves.marketsearch.data.remote.datasource.products.ProductsDataSource
import com.saraalves.marketsearch.domain.model.response.ProductItemData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductsDataSourceImpl(
    private val productsService: ProductsService
) : ProductsDataSource {
    override fun getProducts(id: String): Flow<ProductItemData> {
        return flow {
            emit(productsService.getProducts(id).mapToProductsItem())
        }.parseHttpError()
    }
}