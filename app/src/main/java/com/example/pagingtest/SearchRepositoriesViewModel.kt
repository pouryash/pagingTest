package com.example.pagingtest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class SearchRepositoriesViewModel(private val repository: GithubRepository) : ViewModel() {


    fun searchRepo(): Flow<PagingData<News>> {
        val newResult: Flow<PagingData<News>> = repository.getSearchResultStream()
            .cachedIn(viewModelScope)
        return newResult
    }
}