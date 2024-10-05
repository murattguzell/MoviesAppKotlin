package com.muratguzel.movieapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.switch(view: View,transition:NavDirections){
    findNavController(view).navigate(transition)

}