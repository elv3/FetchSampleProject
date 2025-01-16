package com.av.fetchrewardssample.data

import retrofit2.Response
import retrofit2.http.GET

fun interface ApiService {

    @GET("/hiring.json")
    suspend fun getHiringData(): Response<List<ItemDto>>
}