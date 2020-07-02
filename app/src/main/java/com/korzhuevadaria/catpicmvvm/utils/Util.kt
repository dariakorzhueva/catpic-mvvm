package com.korzhuevadaria.catpicmvvm.utils

import com.korzhuevadaria.catpicmvvm.models.CatItem
import com.korzhuevadaria.catpicmvvm.network.PhotoItem

fun PhotoItem.asDomainModel(): CatItem {
    return CatItem(
            id = id,
            text = text,
            date = date,
            url = photoSizes[2].url
        )
}
