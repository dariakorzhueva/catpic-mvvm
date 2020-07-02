package com.korzhuevadaria.catpicmvvm.network

import androidx.lifecycle.LiveData
import com.korzhuevadaria.catpicmvvm.models.CatItem

class PhotoResponse(
    val count: Int,
    val items: List<PhotoItem>
)