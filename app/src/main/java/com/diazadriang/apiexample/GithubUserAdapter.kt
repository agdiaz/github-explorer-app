package com.diazadriang.apiexample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import com.diazadriang.apiexample.models.GithubUser
import com.squareup.picasso.Picasso

/**
 * Created by diazadriang on 7/31/17.
 */
class GithubUserAdapter(context: Context, users: ArrayList<GithubUser>) : RecyclerView.Adapter<GithubUserHolder>() {
  private val mUsers : ArrayList<GithubUser> = users
  private val mContext : Context = context

  override fun getItemCount(): Int {
    return mUsers.size
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GithubUserHolder {
    val inflatedView = LayoutInflater.from(parent?.context)
        .inflate(R.layout.layout_user_item, parent, false)

    return GithubUserHolder(mContext, inflatedView)
  }

  override fun onBindViewHolder(holder: GithubUserHolder?, position: Int) {
    val user = mUsers[position]
    holder?.bindGithubUser(user)
  }
}

class GithubUserHolder(context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {
  private val mContext : Context = context
  private val mItemImage : ImageView = itemView.findViewById<ImageView>(R.id.imageViewItemPhoto)
  private val mItemTitle : TextView = itemView.findViewById<TextView>(R.id.textViewItemTitle)
  private val mItemUrl : TextView = itemView.findViewById<TextView>(R.id.textViewItemUrl)
  private val mOverflow : ImageView= itemView.findViewById<ImageView>(R.id.overflow)

  private var mUser: GithubUser? = null

  fun bindGithubUser(user: GithubUser) {
    mUser = user

    Picasso.with(mItemImage.context).load(user.avatar_url).into(mItemImage)
    mItemTitle.text = user.login
    mItemUrl.text = user.html_url

    mOverflow.setOnClickListener { view ->
      showPopupMenu(view)
    }
  }

  private fun showPopupMenu(view: View) {
    val popup = PopupMenu(mContext, view)
    val inflater = popup.menuInflater
    inflater.inflate(R.menu.menu_user, popup.menu)
    popup.setOnMenuItemClickListener { menuItem ->
      if (menuItem?.itemId == R.id.action_view_details){
        Log.d("Click", "view details")
        true
      }else {
        false
      }
    }
    popup.show()
  }
}
