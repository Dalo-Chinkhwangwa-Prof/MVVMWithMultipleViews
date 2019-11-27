package com.example.gitmvvmapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gitmvvmapp.model.Commit
import com.example.gitmvvmapp.model.Repository
import com.example.gitmvvmapp.network.GitFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GitViewModel : ViewModel() {

    private val gitFactory = GitFactory()

    fun getRepositories(userName: String): Observable<List<Repository>> {

        return gitFactory
            .getRepositories(userName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    }

    fun getRepoCommits(userName: String, repoName: String): Observable<List<Commit>> {

        return gitFactory
            .getRepoCommits(userName, repoName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    }

}