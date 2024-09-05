package com.saraalves.marketsearch.data.remote.api

import com.saraalves.marketsearch.data.remote.model.response.ProductItemResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsService {

    @GET("/items/{id}")
    suspend fun getProducts(@Path("id") id: String): ProductItemResponse

}