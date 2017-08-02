package com.diazadriang.apiexample.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

/**
 * Created by diazadriang on 7/31/17.
 */
data class GithubUser(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val gravatar_id: String?,
    val url: String,
    val html_url: String) : Parcelable  {

  constructor(parcelIn: Parcel) : this(
      parcelIn.readString(),
      parcelIn.readInt(),
      parcelIn.readString(),
      parcelIn.readString(),
      parcelIn.readString(),
      parcelIn.readString()
  )

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(login)
    parcel.writeInt(id)
    parcel.writeString(avatar_url)
    parcel.writeString(gravatar_id)
    parcel.writeString(url)
    parcel.writeString(html_url)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Creator<GithubUser> {
    override fun createFromParcel(parcel: Parcel): GithubUser {
      return GithubUser(parcel)
    }

    override fun newArray(size: Int): Array<GithubUser?> {
      return arrayOfNulls(size)
    }
  }
}