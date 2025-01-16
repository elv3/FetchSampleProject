package com.av.fetchrewardssample.domain

import com.av.fetchrewardssample.data.ItemDto
import retrofit2.Response

fun interface Repository {
    suspend fun getData(): Response<List<ItemDto>>
}