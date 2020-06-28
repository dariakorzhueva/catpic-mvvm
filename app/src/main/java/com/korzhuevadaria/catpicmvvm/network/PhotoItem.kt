package com.korzhuevadaria.catpicmvvm.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoItem(
    val id: String,
    val albumId: String,
    val ownerId: String,
    val userId: String,
    @Json(name = "img_src") val photoSizes: List<SizeItem>,
    val text: String,
    val date: String,
    val postId: String
) : Parcelable
