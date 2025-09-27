package com.example.proyectofinal.features.movie.data.datasource

import com.example.proyectofinal.features.github.domain.model.UrlPath
import com.example.proyectofinal.features.movie.data.api.MovieService
import com.example.proyectofinal.features.movie.domain.model.MovieModel

class MovieRemoteDataSource(
    private val movieServie: MovieService,
    private val apiKey: String
) {
    suspend fun fetchPopularMovies(): Result<List<MovieModel>> = runCatching {
        val response = movieServie.fetchPopularMovies(apiKey = apiKey)

        if (!response.isSuccessful) {
            val code = response.code()
            val body = response.errorBody()?.string().orEmpty()
            throw Exception("HTTP $code - $body")
        }

        val moviePage = response.body() ?: return@runCatching emptyList()

        moviePage.results.map { dto ->
            MovieModel(
                id = dto.id,
                title = dto.title,
                pathUrl = dto.pathUrl?.let { "https://image.tmdb.org/t/p/w185$it" },
                meGusta = 0
            )
        }
    }
}
