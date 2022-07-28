package com.example.lesson43.di

import com.example.lesson43.data.remote.NetWorkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Singleton
    @Provides
    fun providePeopleApiService(netWorkClient: NetWorkClient) =
        netWorkClient.providePeopleApiService()
}