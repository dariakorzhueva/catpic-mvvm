package com.korzhuevadaria.catpicmvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.korzhuevadaria.catpicmvvm.models.CatItem
import com.korzhuevadaria.catpicmvvm.repository.PhotosRepository
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {
    private val repositoryPhoto = PhotosRepository()

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _photoList = MutableLiveData<List<CatItem>>()
    val photoList: LiveData<List<CatItem>>
        get() = _photoList


    init {
        coroutineScope.launch {
            repositoryPhoto.refreshPhotos()
            _photoList.value = repositoryPhoto.photoConverted
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}