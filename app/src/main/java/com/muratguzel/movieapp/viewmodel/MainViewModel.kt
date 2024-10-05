package com.muratguzel.movieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratguzel.movieapp.data.entity.Movie
import com.muratguzel.movieapp.data.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var mrepo : MovieRepository) :ViewModel() {

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