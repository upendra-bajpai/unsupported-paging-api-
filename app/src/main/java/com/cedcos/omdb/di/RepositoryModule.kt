package com.cedcos.omdb.di

import com.cedcos.omdb.data.repository.MovieRepository
import com.cedcos.omdb.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Upendra on 19/2/2022.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideUserRepository(userRepository: MovieRepositoryImpl): MovieRepository
}