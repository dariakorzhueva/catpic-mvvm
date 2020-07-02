package com.korzhuevadaria.catpicmvvm.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class SizeItem(
    val type: String,
    val url: String,
    val width: String,
    val height: String
) : Parcelable
