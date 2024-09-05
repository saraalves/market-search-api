package com.saraalves.marketsearch.presentation.ptoducts

import ConnectionError
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saraalves.marketsearch.R
import com.saraalves.marketsearch.domain.model.response.ProductItemData
import com.saraalves.marketsearch.domain.model.response.SearchData
import com.saraalves.marketsearch.domain.usecase.GetProductsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _productItem = MutableLiveData<ProductItemData>()
    var productItem: LiveData<ProductItemData> = _productItem

    private val _loading = MutableLiveData<Boolean>()
    var loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<Pair<Int, Int>>()
    var error: LiveData<Pair<Int, Int>> = _error

    private fun getProductDetail(id: String) {
        viewModelScope.launch {
            getProductsUseCase(id)
                .flowOn(dispatcher)
                .onStart { _loading.value = true }
                .catch { handleError(it) }
                .onCompletion { _loading.value = false }
                .collect { _productItem.value = it }
        }
    }

    private fun handleError(error: Throwable) {
        when (error) {
            is ConnectionError -> _error.value = Pair(R.string.connection_error_title, R.string.connection_error_msg)
            else -> _error.value = Pair(R.string.error_title, R.string.error_msg)
        }
    }


}