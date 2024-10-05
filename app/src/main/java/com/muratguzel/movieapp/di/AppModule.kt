package com.muratguzel.movieapp.di

import com.muratguzel.movieapp.data.datasource.MovieDatasource
import com.muratguzel.movieapp.data.repo.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMovieDatasource(): MovieDatasource {
        return MovieDatasource()
    }
    @Provides
    @Singleton
    fun provideMovieRepository(mds: MovieDatasource): MovieRepository {
        return MovieRepository(mds)
    }
}