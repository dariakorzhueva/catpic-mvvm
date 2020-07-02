package com.korzhuevadaria.catpicmvvm.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CatItem(
    val id: String,
    val text: String,
    val date: String,
    val url: String
) : Parcelable