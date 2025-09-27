package com.example.proyectofinal.features.movie.data.database.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyectofinal.features.movie.data.database.entity.MovieEntity

@Dao
interface IMovieDao {
    @Query("SELECT * FROM movies")
    suspend fun getList(): List<MovieEntity>




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movies: MovieEntity)




    @Query("DELETE FROM movies")
    suspend fun deleteAll()




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDollars(lists: List<MovieEntity>)

    @Query("UPDATE movies SET meGusta = :like WHERE id = :movieId")
    suspend fun updateLike(movieId: Int, like: Int)

}