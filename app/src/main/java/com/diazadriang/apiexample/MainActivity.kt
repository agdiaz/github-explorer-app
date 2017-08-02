package com.diazadriang.apiexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import com.diazadriang.apiexample.models.GithubUser
import com.jakewharton.rxbinding.view.RxView

class MainActivity : AppCompatActivity() {
  private val mUsers = ArrayList<GithubUser>()
  private var mAdapter: GithubUserAdapter? = null
  private var mListPresenter: GithubUsersListPresenter? = null
  private var mLinearLayoutManager: LinearLayoutManager? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setRecyclerView()
    setObservers()
  }

  override fun onStart() {
    super.onStart()

    if (mUsers.isEmpty()) {
      mListPresenter?.loadUsers()
    }
  }

  fun setRecyclerView(){
    val recyclerView = findViewById(R.id.recycler_view) as RecyclerView
    mLinearLayoutManager = LinearLayoutManager(this)
    recyclerView.layoutManager = mLinearLayoutManager

    mAdapter = GithubUserAdapter(this, mUsers)
    mListPresenter = GithubUsersListPresenter(this, GithubService())

    recyclerView.adapter = mAdapter
  }

  fun setObservers(){
    RxView.clicks(findViewById(R.id.queryButton))
        .subscribe {
          Log.d("observer", "Click on queryButton")
          mListPresenter?.loadUsers()
        }
  }

  fun displayUsers(users: List<GithubUser>) {
    mUsers.clear()
    mAdapter?.notifyDataSetChanged()

    mUsers.addAll(users)
    mAdapter?.notifyItemRangeInserted(0, users.size)
  }
}
