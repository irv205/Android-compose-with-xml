package com.irv205.composewithxml.core.di

import com.irv205.composewithxml.data.repository.RepositoryImp
import com.irv205.composewithxml.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repositoryImp: RepositoryImp): Repository
}