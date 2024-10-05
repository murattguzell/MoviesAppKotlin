package com.muratguzel.movieapp.data.repo

import com.muratguzel.movieapp.data.datasource.MovieDatasource
import com.muratguzel.movieapp.data.entity.Movie

class MovieRepository(var mds: MovieDatasource) {

    suspend fun downloadMovies(): List<Movie> = mds.downloadMovies()
}