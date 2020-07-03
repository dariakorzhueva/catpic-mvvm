package com.korzhuevadaria.catpicmvvm.network

import com.squareup.moshi.Json

data class PhotoItem(
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
)
