package com.example.proyectofinal.features.movie.data.datasource

import com.example.proyectofinal.features.github.domain.model.UrlPath
import com.example.proyectofinal.features.movie.data.api.MovieService
import com.example.proyectofinal.features.movie.domain.model.MovieModel

class MovieRemoteDataSource(
    private val movieServie: MovieService,
    private val apiKey: String
) {
    suspend fun fetchPopularMovies(): Result<List<MovieModel>> {
        val response = movieServie.fetchPopularMovies(apiKey = apiKey)
        return if (response.isSuccessful) {
            val moviePage = response.body()
            if (moviePage != null) {
                Result.success(moviePage.results.map { dto ->
                    MovieModel(
                        id = dto.id,
                        title = dto.title,
                        pathUrl = "https://image.tmdb.org/t/p/w185${dto.pathUrl}"
                    )
                })
            } else {
                Result.success(emptyList())
            }
        } else {
            Result.failure(Exception("Error"))
        }
    }

}