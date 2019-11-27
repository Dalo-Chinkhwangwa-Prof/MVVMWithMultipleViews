package com.example.gitmvvmapp.network

import com.example.gitmvvmapp.model.Commit
import com.example.gitmvvmapp.model.Repository
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {
    @GET("users/{user_name}/repos")
    fun getUser(@Path("user_name") userName: String): Observable<List<Repository>>

    @GET("repos/{user_name}/{repo_name}/commits")
    fun getRepoCommits(
        @Path("user_name") userName: String,
        @Path("repo_name") repoName: String
    ): Observable<List<Commit>>

}