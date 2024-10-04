package com.muratguzel.movieapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.muratguzel.movieapp.R
import com.muratguzel.movieapp.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle: DetailsFragmentArgs by navArgs()
        val movie = bundle.movie
       binding.movie= movie
        binding.ivMovie.setImageResource(resources.getIdentifier(movie.image, "drawable", requireContext().packageName))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}