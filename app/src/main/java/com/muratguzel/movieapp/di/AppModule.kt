package com.muratguzel.movieapp.di

import com.example.filmlerapp.retrofit.ApiUtils
import com.muratguzel.movieapp.data.datasource.MovieDatasource
import com.muratguzel.movieapp.data.repo.MovieRepository
import com.muratguzel.movieapp.retrofit.MovieDao
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
    fun provideMovieDatasource(mdo: MovieDao): MovieDatasource {
        return MovieDatasource(mdo)
    }
    @Provides
    @Singleton
    fun provideMovieRepository(mds: MovieDatasource): MovieRepository {
        return MovieRepository(mds)
    }
    @Provides
    @Singleton
    fun provideMovieDao(): MovieDao {
        return ApiUtils.getMovieDao()
    }
}