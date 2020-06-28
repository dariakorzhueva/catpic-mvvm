package com.korzhuevadaria.catpicmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.korzhuevadaria.catpicmvvm.models.CatItem
import com.korzhuevadaria.catpicmvvm.network.PhotoItem
import com.korzhuevadaria.catpicmvvm.network.VkApi
import com.korzhuevadaria.catpicmvvm.utils.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await

class PhotosRepository() {
    lateinit var photoConverted: LiveData<List<CatItem>>

    suspend fun refreshPhotos() {
        withContext(Dispatchers.IO) {
            val vkResponse = VkApi.retrofitService.getWallPhotos().await()
            var photos: MutableLiveData<List<PhotoItem>> = MutableLiveData()
            photos.value = vkResponse.response.items

            photoConverted = Transformations.map(photos){
                it.asDomainModel()
            }
        }
    }
}