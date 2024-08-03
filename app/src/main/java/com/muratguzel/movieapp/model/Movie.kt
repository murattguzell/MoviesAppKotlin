package com.muratguzel.movieapp.model

import java.io.Serializable

data class Movie(
    var id: Int,
    var name: String,
    var image: String,
    var price: String,
) : Serializable