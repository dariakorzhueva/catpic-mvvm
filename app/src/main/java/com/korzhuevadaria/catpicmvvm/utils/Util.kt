package com.korzhuevadaria.catpicmvvm.utils

import com.korzhuevadaria.catpicmvvm.models.CatItem
import com.korzhuevadaria.catpicmvvm.network.PhotoItem

fun List<PhotoItem>.asDomainModel(): List<CatItem> {
    return map {
        CatItem(
            id = it.id,
            text = it.text,
            date = it.date,
            url = it.photoSizes[2].url
        )
    }
}
