package com.muratguzel.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.muratguzel.movieapp.R
import com.muratguzel.movieapp.databinding.MovieRowBinding
import com.muratguzel.movieapp.data.entity.Movie
import com.muratguzel.movieapp.util.switch
import com.muratguzel.movieapp.view.MainFragmentDirections

class MovieAdapter(var context: Context, var movieList: List<Movie>) :
        RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    class MovieHolder(val binding: MovieRowBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding: MovieRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.movie_row,parent, false)
        return MovieHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.movie = movie
        val url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${movie.resim}"
        Glide.with(context).load(url).override(500, 750).into(holder.binding.imageView)
        holder.binding.cardViewMovie.setOnClickListener {
            Navigation.switch(it, MainFragmentDirections.actionMainFragmentToDetailsFragment(movie = movie))
        }
        holder.binding.btnAddToCart.setOnClickListener {
            Snackbar.make(it, "${movie.ad} Sepete eklendi", Snackbar.LENGTH_SHORT).show()
        }
    }
}