package com.muratguzel.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.muratguzel.movieapp.databinding.MovieRowBinding
import com.muratguzel.movieapp.model.Movie
import com.muratguzel.movieapp.view.MainFragmentDirections

class MovieAdapter(var context: Context, var movieList: List<Movie>) :
        RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    class MovieHolder(val binding: MovieRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding = MovieRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.imageView.setImageResource(context.resources.getIdentifier(movie.image,"drawable",context.packageName))
        holder.binding.tvPrice.text = "${movie.price} ₺"
        holder.binding.cardViewMovie.setOnClickListener {
            val transition = MainFragmentDirections.actionMainFragmentToDetailsFragment(movie)
            Navigation.findNavController(it).navigate(transition)
        }
        holder.binding.btnAddToCart.setOnClickListener {
            Snackbar.make(it, "${movie.name} Sepete eklendi", Snackbar.LENGTH_SHORT).show()
        }
    }
}