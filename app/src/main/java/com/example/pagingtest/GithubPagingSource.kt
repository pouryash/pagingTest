package com.example.pagingtest

import androidx.paging.PagingSource
import retrofit2.HttpException
import java.io.IOException

private const val PAGE_INDEX = 1

class GithubPagingSource(
    private val service: Api
) : PagingSource<Int, News>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, News> {
        val position = params.key ?: PAGE_INDEX
        return try {
            val response = service.getNews(position, params.loadSize)
            val repos = response.news
            LoadResult.Page(
                data = repos,
                prevKey = if (position == PAGE_INDEX) null else position - 1,
                nextKey = if (repos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}