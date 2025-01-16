package com.av.fetchrewardssample.data

import com.av.fetchrewardssample.domain.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
): Repository {

    override suspend fun getData(): Response<List<ItemDto>> {
        return apiService.getHiringData()
    }
}