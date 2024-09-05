package com.saraalves.marketsearch.data.repository

import retrofit2.HttpException
import android.os.RemoteException
import com.saraalves.marketsearch.data.remote.datasource.products.ProductsDataSource
import com.saraalves.marketsearch.domain.model.response.ProductItemData
import com.saraalves.marketsearch.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductsRepositoryImpl(private val productDataSource: ProductsDataSource) :
    ProductsRepository {
    override fun getProducts(id: String): Flow<ProductItemData> = flow {
        try {
            getProductsData(id).collect {
                emit(it)
            }

        } catch (ex: HttpException) {
            throw RemoteException()
        }
    }

    private fun getProductsData(id: String): Flow<ProductItemData> =
        productDataSource.getProducts(id)
}