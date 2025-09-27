package com.example.proyectofinal.features.movie.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.proyectofinal.features.movie.data.database.dao.IMovieDao
import com.example.proyectofinal.features.movie.data.database.entity.MovieEntity


@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieRoomDatabase : RoomDatabase() {
    abstract fun movieDao(): IMovieDao

    companion object {
        @Volatile
        private var Instance: MovieRoomDatabase? = null




        fun getDatabase(context: Context): MovieRoomDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, MovieRoomDatabase::class.java, "movies_db")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
