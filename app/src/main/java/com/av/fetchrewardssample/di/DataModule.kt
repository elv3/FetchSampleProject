package com.av.fetchrewardssample.di

import com.av.fetchrewardssample.data.ApiService
import com.av.fetchrewardssample.data.RepositoryImpl
import com.av.fetchrewardssample.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideRepository(
        apiService: ApiService
    ): Repository = RepositoryImpl(apiService)
}