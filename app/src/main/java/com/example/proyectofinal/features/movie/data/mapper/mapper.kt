package com.example.proyectofinal.features.movie.data.mapper

import com.example.proyectofinal.features.movie.data.database.entity.MovieEntity
import com.example.proyectofinal.features.movie.domain.model.MovieModel

fun MovieEntity.toModel() : MovieModel {
    return MovieModel(
        id = id,
        title= title,
        pathUrl = pathUrl,
        meGusta = meGusta ?: 0
    )
}

fun MovieModel.toEntity() : MovieEntity {
    return MovieEntity(
        id = id,
        title= title,
        pathUrl = pathUrl,
        meGusta = meGusta ?: 0
    )
}