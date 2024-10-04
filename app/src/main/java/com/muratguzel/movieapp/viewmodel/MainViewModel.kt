package com.muratguzel.movieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratguzel.movieapp.data.entity.Movie
import com.muratguzel.movieapp.data.repo.MovieRepository
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    var mrepo = MovieRepository()
    var movieList = MutableLiveData<List<Movie>>()

    init {
        downloadMovies()
    }

    fun downloadMovies(){
        viewModelScope.launch {
            val list = mrepo.downloadMovies()
            movieList.value = list
        }
    }
}