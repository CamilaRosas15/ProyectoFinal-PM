package com.example.proyectofinal.features.movie.data.datasource

import com.example.proyectofinal.features.movie.data.database.dao.IMovieDao
import com.example.proyectofinal.features.movie.data.mapper.toEntity
import com.example.proyectofinal.features.movie.data.mapper.toModel
import com.example.proyectofinal.features.movie.domain.model.MovieModel

class MovieLocalDataSource(
    private val dao: IMovieDao
) {
    suspend fun getList(): List<MovieModel> = dao.getList().map { it.toModel() }

    suspend fun deleteAll() = dao.deleteAll()

    suspend fun insertMovies(list: List<MovieModel>) {
        dao.insertDollars(list.map { it.toEntity() })
    }

    suspend fun insert(movie: MovieModel) {
        dao.insert(movie.toEntity())
    }

    suspend fun updateLike(movieId: Int, like: Int) {
        dao.updateLike(movieId, like)
    }
}
