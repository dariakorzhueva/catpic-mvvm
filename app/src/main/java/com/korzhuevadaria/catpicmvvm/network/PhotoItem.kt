package com.korzhuevadaria.catpicmvvm.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
class PhotoItem(
    val id: String,
    @Json(name = "album_id")
    val albumId: String,
    @Json(name = "owner_id")
    val ownerId: String,
    @Json(name = "user_id")
    val userId: String,
    @Json(name = "sizes")
    val photoSizes: List<SizeItem>,
    @Json(name = "text")
    val text: String,
    @Json(name = "date")
    val date: String
) : Parcelable
