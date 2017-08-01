package com.diazadriang.apiexample

import android.util.Log
import com.diazadriang.apiexample.models.GithubUser
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by diazadriang on 7/31/17.
 */
class GithubUsersListPresenter(activity: MainActivity, service: GithubService ){
  private val mActivity= activity
  private val mService = service

  fun loadUsers(){
    mService.getApi()
        .getUsers()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { users ->
              Log.d("ListPresenter", "Users: ${users.size}")
              mActivity.displayUsers(users)
            },
            { e ->
              Log.e("ListPresenter", e.toString() )
            },
            {
              Log.i("ListPresenter", "Completed")
            }
        )
  }
}