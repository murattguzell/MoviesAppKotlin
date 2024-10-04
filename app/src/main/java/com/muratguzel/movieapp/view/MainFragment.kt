package com.muratguzel.movieapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.muratguzel.movieapp.R
import com.muratguzel.movieapp.adapter.MovieAdapter
import com.muratguzel.movieapp.databinding.FragmentMainBinding
import com.muratguzel.movieapp.data.entity.Movie
import com.muratguzel.movieapp.viewmodel.MainViewModel

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieAdapter: MovieAdapter
    private var movieList: ArrayList<Movie> = arrayListOf()
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.mainToolBarTitle = "Filmler"
        viewModel.movieList.observe(viewLifecycleOwner){movieList->
            if (movieList!=null){
                movieAdapter = MovieAdapter(requireContext(), movieList)
                binding.moviesAdapter = movieAdapter
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}