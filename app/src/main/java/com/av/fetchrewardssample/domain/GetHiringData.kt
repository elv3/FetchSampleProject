package com.av.fetchrewardssample.domain

import com.av.fetchrewardssample.data.toItem
import com.av.fetchrewardssample.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetHiringData @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(): Flow<Resource<List<Item>>> = flow {
        emit(Resource.Loading())

        try {
            val response = repository.getData()

            if(response.isSuccessful) {
                val list = response.body()?.map { it.toItem() } ?: emptyList()
                emit(Resource.Success(list))
            }
            else {
                emit(Resource.Error("Unable to obtain data. Try again in a few minutes."))
            }
        }
        catch (ex: Exception) {
            val errorMsg = "Unable to obtain data. Try again in a few minutes."
            emit(Resource.Error(errorMsg))
        }
    }
}