package com.saraalves.marketsearch.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saraalves.marketsearch.domain.model.response.SearchData
import com.saraalves.marketsearch.domain.usecase.GetSearchUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.random.Random

class SearchViewModel(
    private val getSearchUseCase: GetSearchUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val _searchProduct = MutableLiveData<SearchData>()
    var searchProducts: LiveData<SearchData> = _searchProduct

    private val _loading = MutableLiveData<Boolean>()
    var loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<Pair<Int, Int>>()
    var error: LiveData<Pair<Int, Int>> = _error

    private val offset = Random.nextInt(1, 18)

    private fun getSearchProdcuts(query: String?) {
        viewModelScope.launch {
                getSearchUseCase("MLA", query.orEmpty(), 0)
                    .flowOn(dispatcher)
                    .onStart { }
                    .catch {  }
                    .onCompletion {  }
                    .collect { _searchProduct.value = it }
        }
    }

    fun doSeacrh(search: String) {
        getSearchProdcuts(search)
    }


}