package com.example.proyectofinal.features.movie.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,                           // <-- SIN autoGenerate

    @ColumnInfo(name = "title")
    val title: String? = null,

    @ColumnInfo(name = "pathUrl")
    val pathUrl: String? = null,

    @ColumnInfo(name = "meGusta", defaultValue = "0")
    val meGusta: Int = 0

    )