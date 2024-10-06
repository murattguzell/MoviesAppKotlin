package com.muratguzel.movieapp.data.datasource

import com.muratguzel.movieapp.data.entity.Movie
import com.muratguzel.movieapp.retrofit.MovieDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDatasource (var mdao: MovieDao){
    suspend fun downloadMovies(): List<Movie> =
          withContext(Dispatchers.IO) {
          return@withContext  mdao.downloadMovies().filmler
        }
    }

