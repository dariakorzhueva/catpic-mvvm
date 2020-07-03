package com.korzhuevadaria.catpicmvvm.network

data class PhotoResponse(
    val count: Int,
    val items: List<PhotoItem>
)