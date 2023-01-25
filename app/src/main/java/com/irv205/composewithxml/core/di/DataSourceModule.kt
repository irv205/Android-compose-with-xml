package com.irv205.composewithxml.core.di

import com.irv205.composewithxml.data.networkdatasource.NetworkDataSourceImp
import com.irv205.composewithxml.domain.service.NetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun provideNetworkSource(networkDataSourceImp: NetworkDataSourceImp): NetworkDataSource
}