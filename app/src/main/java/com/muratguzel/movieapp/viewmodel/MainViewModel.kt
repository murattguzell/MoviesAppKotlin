package com.muratguzel.movieapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratguzel.movieapp.data.entity.Movie
import com.muratguzel.movieapp.data.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var mrepo : MovieRepository) :ViewModel() {

    var movieList = MutableLiveData<List<Movie>>()

    init {
        downloadMovies()
    }

    private fun downloadMovies(){
        viewModelScope.launch(Dispatchers.Main) {
            movieList.value = mrepo.downloadMovies()
            Log.e("Film listesi","${movieList.value}")
        }
    }
}