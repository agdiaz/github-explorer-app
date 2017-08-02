package com.diazadriang.apiexample

import android.util.Log
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by diazadriang on 8/1/17.
 */
class GithubRepositoryListPresenter(val activity: UserDetails, val service: GithubService) {

  fun getRepositories(user: String) {
   service.getApi().getUserRepos(user)
       .subscribeOn(Schedulers.io())
       .observeOn(AndroidSchedulers.mainThread())
       .subscribe(
           { activity.displayRepositories(it) },
           { Log.e("GithubRepositories", it.toString()) },
           { Log.i("GithubRepositories", "Completed") }
       )
  }
}