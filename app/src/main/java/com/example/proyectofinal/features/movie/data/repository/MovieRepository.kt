package com.example.proyectofinal.features.movie.data.repository

import com.example.proyectofinal.features.movie.data.datasource.MovieRemoteDataSource
import com.example.proyectofinal.features.movie.domain.model.MovieModel
import com.example.proyectofinal.features.movie.domain.repository.IMoviesRepository

class MovieRepository(
    private val movieRemoteDataSource: MovieRemoteDataSource
): IMoviesRepository {
    override suspend fun fetchPopularMovies(): Result<List<MovieModel>>
            = movieRemoteDataSource.fetchPopularMovies()

}