package com.korzhuevadaria.catpicmvvm.repository

import com.korzhuevadaria.catpicmvvm.models.CatItem
import com.korzhuevadaria.catpicmvvm.network.VkApi
import com.korzhuevadaria.catpicmvvm.utils.asDomainModel

class PhotosRepository() {
    lateinit var photoConverted: List<CatItem>

    suspend fun refreshPhotos() {
        val vkResponse = VkApi.retrofitService.getWallPhotos().await()

        photoConverted = vkResponse.response.items.map {
            it.asDomainModel()
        }
    }
}