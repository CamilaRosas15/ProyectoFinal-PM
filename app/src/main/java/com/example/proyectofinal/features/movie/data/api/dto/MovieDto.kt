package com.example.proyectofinal.features.movie.data.api.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    val id: Int,
    @SerializedName("poster_path")
    val pathUrl: String,
    val title: String
)