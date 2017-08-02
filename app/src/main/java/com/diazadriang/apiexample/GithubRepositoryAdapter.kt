package com.diazadriang.apiexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by diazadriang on 8/1/17.
 */

class GithubRepositoryAdapter(repos: List<GithubRepository>) : RecyclerView.Adapter<GithubRepositoryHolder>() {
  private val mRepos : List<GithubRepository> = repos

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GithubRepositoryHolder {
    val inflatedView = LayoutInflater.from(parent?.context)
        .inflate(R.layout.layout_repository_item, parent, false)

    return GithubRepositoryHolder(inflatedView)
  }

  override fun getItemCount(): Int {
    return mRepos.size
  }

  override fun onBindViewHolder(holder: GithubRepositoryHolder?, position: Int) {
    holder?.bindRepository(mRepos[position])
  }
}

class GithubRepositoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  private val mTitle = itemView.findViewById<TextView>(R.id.textViewRepositoryTitle)
  private val mDescription = itemView.findViewById<TextView>(R.id.textViewRepositoryDescription)
  private val mLanguage = itemView.findViewById<TextView>(R.id.textViewRepositoryLanguage)
  private val mPrivate = itemView.findViewById<TextView>(R.id.textViewRepositoryPrivate)

  fun bindRepository(repo: GithubRepository){
    mTitle.text = repo.full_name
    mDescription.text = repo.description
    mLanguage.text = "Written in ${repo.language}"
    mPrivate.text = if (repo.private) "Private" else "Public"
  }
}
