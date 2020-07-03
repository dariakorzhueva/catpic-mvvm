package com.korzhuevadaria.catpicmvvm.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.korzhuevadaria.catpicmvvm.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
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
        @Query("owner_id") owner: String? = "-130670107",
        @Query("album_id") album: String? = "wall",
        @Query("rev") rev: Int = 1,
        @Query("count") count: Int = 21,
        @Query("access_token") token: String? = BuildConfig.VKApiKey,
        @Query("v") version: String? = "5.101"
    ): Deferred<VkResponse>

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
        @Query("owner_id") owner: String? = "-130670107",
        @Query("album_id") album: String? = "wall",
        @Query("rev") rev: Int = 0,
        @Query("count") count: Int = 100,
        @Query("offset") offset: Int,
        @Query("access_token") token: String? = BuildConfig.VKApiKey,
        @Query("v") version: String? = "5.101"
    ): Deferred<VkResponse>
}

object VkApi {
    val retrofitService: VkApiService by lazy { retrofit.create(VkApiService::class.java) }
}