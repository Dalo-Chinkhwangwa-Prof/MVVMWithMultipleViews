package com.example.gitmvvmapp.network

import com.example.gitmvvmapp.model.Commit
import com.example.gitmvvmapp.model.Repository
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GitFactory {

    private val BASE_URL = "https://api.github.com"
    private var gitService: GitService

    init {
        gitService = createService(retrofitInstance())
    }

    private fun retrofitInstance(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun createService(retrofit: Retrofit): GitService {
        return retrofit.create(GitService::class.java)
    }

    fun getRepositories(userName: String): Observable<List<Repository>> {
        return gitService.getUser(userName)
    }

    fun getRepoCommits(userName: String, repositoryName: String): Observable<List<Commit>> {
        return gitService.getRepoCommits(userName, repositoryName)
    }

}