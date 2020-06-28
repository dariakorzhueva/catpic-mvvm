package com.korzhuevadaria.catpicmvvm.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.vk.com/method/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface VkApiService {
    /* Получение фотографий из альбома
     * owner - идентификатор владельца альбома
     * album - идентификатор альбома
     * rev - порядок сортировки фотографий
     * count - количество фотографий
     * token - ключ доступа
     * version - версия API */
    @GET("photos.get?")
    open fun getWallPhotos(
        @Query("owner_id") owner: String?,
        @Query("album_id") album: String?,
        @Query("rev") rev: Int,
        @Query("count") count: Int,
        @Query("access_token") token: String?,
        @Query("v") version: String?
    ): Call<VkResponse>

    /* Получение последующих фотографий из альбома
     * owner - идентификатор владельца альбома
     * album - идентификатор альбома
     * rev - порядок сортировки фотографий
     * count - количество фотографий
     * offset - отступ, необходимый для получения определенного подмножества записей
     * token - ключ доступа
     * version - версия API */
    @GET("photos.get?")
    open fun getFromPositionWallPhotos(
        @Query("owner_id") owner: String?,
        @Query("album_id") album: String?,
        @Query("rev") rev: Int,
        @Query("count") count: Int,
        @Query("offset") offset: Int,
        @Query("access_token") token: String?,
        @Query("v") version: String?
    ): Call<VkResponse>
}

object VkApi {
    val retrofitService: VkApiService by lazy { retrofit.create(VkApiService::class.java) }
}