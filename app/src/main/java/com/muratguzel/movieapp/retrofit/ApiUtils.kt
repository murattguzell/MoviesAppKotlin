package com.example.filmlerapp.retrofit

import com.muratguzel.movieapp.retrofit.MovieDao

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getMovieDao() : MovieDao {
            return RetrofitClient.getClient(BASE_URL).create(MovieDao::class.java)
        }
    }
}