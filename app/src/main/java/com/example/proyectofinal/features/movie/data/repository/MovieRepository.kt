package com.example.proyectofinal.features.movie.data.repository

import com.example.proyectofinal.features.movie.data.datasource.MovieLocalDataSource
import com.example.proyectofinal.features.movie.data.datasource.MovieRemoteDataSource
import com.example.proyectofinal.features.movie.domain.model.MovieModel
import com.example.proyectofinal.features.movie.domain.repository.IMoviesRepository

class MovieRepository(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
): IMoviesRepository {
    override suspend fun fetchPopularMovies(): Result<List<MovieModel>> =
        movieRemoteDataSource.fetchPopularMovies().mapCatching { remote ->
            val likesById = movieLocalDataSource
                .getList()
                .associate { it.id to (it.meGusta ?: 0) }

            remote
                .map { m -> m.copy(meGusta = likesById[m.id] ?: (m.meGusta ?: 0)) }
                .sortedWith(
                    compareByDescending<MovieModel> { (it.meGusta ?: 0) }  // likes primero
                        .thenBy { it.title ?: "" }                         // opcional
                )
        }

}