package com.example.proyectofinal.features.movie.domain.model

import com.example.proyectofinal.features.github.domain.model.UrlPath

data class MovieModel(
    val pathUrl: UrlPath,    //String
    val title: String
)