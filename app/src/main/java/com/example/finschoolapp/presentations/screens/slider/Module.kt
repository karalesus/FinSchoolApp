package com.example.finschoolapp.presentations.screens.slider

import androidx.annotation.DrawableRes
import com.example.finschoolapp.R

data class Module(
    val id: Int,
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)
