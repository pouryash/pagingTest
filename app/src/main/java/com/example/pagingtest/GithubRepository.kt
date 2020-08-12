package com.example.pagingtest

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class GithubRepository(private val service: Api) {

    fun getSearchResultStream(): Flow<PagingData<News>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false, initialLoadSize = NETWORK_PAGE_SIZE * 2 ),
            pagingSourceFactory = { GithubPagingSource(service) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 5
    }
}