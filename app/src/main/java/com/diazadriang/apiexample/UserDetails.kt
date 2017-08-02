package com.diazadriang.apiexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.diazadriang.apiexample.models.GithubUser

class UserDetails : AppCompatActivity() {
  private var mLinearLayoutManager: LinearLayoutManager? = null
  private var mAdapter : GithubRepositoryAdapter? = null
  private var mRepos: ArrayList<GithubRepository> = ArrayList()
  private var mListPresenter: GithubRepositoryListPresenter? = null
  private var mUser: String? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_user_details)

    val intent = Intent(intent)
    mUser = intent.getStringExtra("USER")

    mLinearLayoutManager = LinearLayoutManager(this)
    mAdapter = GithubRepositoryAdapter(mRepos)

    val recyclerView = findViewById(R.id.repositories_recycler_view) as RecyclerView
    recyclerView.layoutManager = mLinearLayoutManager
    recyclerView.adapter = mAdapter
    mListPresenter = GithubRepositoryListPresenter(this, GithubService())

  }

  override fun onStart() {
    super.onStart()

    if (mRepos.isEmpty()){
      mListPresenter?.getRepositories(mUser ?: "")
    }
  }

  fun displayRepositories(repos: List<GithubRepository>){
    mRepos.clear()
    mAdapter?.notifyDataSetChanged()

    mRepos.addAll(repos)
    mAdapter?.notifyItemRangeInserted(0, repos.size)
  }
}
