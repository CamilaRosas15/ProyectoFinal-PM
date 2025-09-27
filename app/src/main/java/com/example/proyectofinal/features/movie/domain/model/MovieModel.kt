package com.example.proyectofinal.features.movie.domain.model

import com.example.proyectofinal.features.github.domain.model.UrlPath

data class MovieModel(
    val title: String? = null,
    val pathUrl: String? = null,
    val id: Int = 0,

    val meGusta: Int? = null

)