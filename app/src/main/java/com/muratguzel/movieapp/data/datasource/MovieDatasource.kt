package com.muratguzel.movieapp.data.datasource

import com.muratguzel.movieapp.data.entity.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDatasource {
    suspend fun downloadMovies(): List<Movie> =
          withContext(Dispatchers.IO) {

            val movieList: ArrayList<Movie> = arrayListOf()
            val movie1 = Movie(1, "Django", "django", "24")
            val movie2 = Movie(2, "Interstellar", "interstellar", "32")
            val movie3 = Movie(3, "Inception", "inception", "16")
            val movie4 = Movie(4, "The Hateful Eight", "thehatefuleight", "28")
            val movie5 = Movie(5, "The Pianist", "thepianist", "18")
            val movie6 = Movie(6, "Anadoluda", "anadoluda", "10")
            movieList.add(movie1)
            movieList.add(movie2)
            movieList.add(movie3)
            movieList.add(movie4)
            movieList.add(movie5)
            movieList.add(movie6)
          return@withContext  movieList
        }
    }

