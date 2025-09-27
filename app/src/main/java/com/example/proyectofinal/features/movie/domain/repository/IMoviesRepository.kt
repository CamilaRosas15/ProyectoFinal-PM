package com.example.proyectofinal.features.movie.domain.repository

import com.example.proyectofinal.features.movie.domain.model.MovieModel

interface IMoviesRepository {
    suspend fun fetchPopularMovies(): Result<List<MovieModel>>
}