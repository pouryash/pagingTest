package com.example.pagingtest

import androidx.lifecycle.ViewModelProvider

object Injection {


    private fun provideGithubRepository(): GithubRepository {
        return GithubRepository(Api.create())
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return ViewModelFactory(provideGithubRepository())
    }

}