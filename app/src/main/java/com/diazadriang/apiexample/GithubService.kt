package com.diazadriang.apiexample

import com.diazadriang.apiexample.models.GithubUser
import retrofit.RestAdapter
import retrofit.http.GET
import retrofit.http.Headers
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable
import java.util.Random

/**
 * Created by diazadriang on 7/31/17.
 */
class GithubService {

  private val GITHUB_URL = "https://api.github.com"
  private var githubApi: GithubApi

  init {
    val restAdapter = RestAdapter.Builder()
        .setEndpoint(GITHUB_URL)
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .build()
    
    githubApi = restAdapter.create(GithubApi::class.java)
  }

  fun getApi() : GithubApi {
    return githubApi
  }

  interface GithubApi {
    @Headers("Accept: application/json")

    @GET("/users")
    fun getUsers(@Query("since") since: Int = Random().nextInt(500)) : Observable<List<GithubUser>>

    @GET("/users/{user}/repos")
    fun getUserRepos(@Path("user") user: String) : Observable<List<GithubRepository>>
  }
}