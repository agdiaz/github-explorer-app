package com.diazadriang.apiexample.models

/**
 * Created by diazadriang on 7/31/17.
 */
data class GithubUser(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val gravatar_id: String?,
    val url: String,
    val html_url: String)