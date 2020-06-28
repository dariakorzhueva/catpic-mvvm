package com.korzhuevadaria.catpicmvvm.network

import java.util.*

class PhotoResponse(
    val count: Int,
    val items: List<PhotoItem> = ArrayList<PhotoItem>()
)