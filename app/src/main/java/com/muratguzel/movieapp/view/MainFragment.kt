package com.muratguzel.movieapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.muratguzel.movieapp.adapter.MovieAdapter
import com.muratguzel.movieapp.databinding.FragmentMainBinding
import com.muratguzel.movieapp.model.Movie

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieAdapter: MovieAdapter
    private var movieList: ArrayList<Movie> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarMain.title = "Filmler"
        binding.movieRV.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        movieAdapter = MovieAdapter(requireContext(), movieList)
        binding.movieRV.adapter = movieAdapter
    }

    private fun setData() {
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}