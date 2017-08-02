package com.diazadriang.apiexample

/**
 * Created by diazadriang on 8/1/17.
 */
data class GithubRepository(
    val id: Int,
    val full_name: String? = "No title",
    val private: Boolean,
    val description: String? = "No description provided",
    val language: String? = "Many languages")