package com.example.proyectofinal.core.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.proyectofinal.features.dollar.data.database.dao.IDollarDao
import com.example.proyectofinal.features.dollar.data.database.entity.DollarEntity
import com.example.proyectofinal.features.movie.data.database.dao.IMovieDao
import com.example.proyectofinal.features.movie.data.database.entity.MovieEntity

@Database(
    entities = [
        DollarEntity::class,
        MovieEntity::class
    ],
    version = 9,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dollarDao(): IDollarDao
    abstract fun movieDao(): IMovieDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}