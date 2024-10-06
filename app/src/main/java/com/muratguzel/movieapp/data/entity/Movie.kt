package com.muratguzel.movieapp.data.entity

import java.io.Serializable

data class Movie(var id:Int,
                   var ad:String,
                   var resim:String,
                   var fiyat:Int) : Serializable {
}