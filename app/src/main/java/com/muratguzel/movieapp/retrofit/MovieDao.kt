package com.muratguzel.movieapp.retrofit

import com.muratguzel.movieapp.data.entity.MoviesAnswer
import retrofit2.http.GET

interface MovieDao {

    //http://kasimadalan.pe.hu/filmler_yeni/tum_filmler.php
    //http://kasimadalan.pe.hu/ -> base url
    //filmler_yeni/tum_filmler.php -> webservis url
    @GET("filmler_yeni/tum_filmler.php")
    suspend fun downloadMovies(): MoviesAnswer
}



