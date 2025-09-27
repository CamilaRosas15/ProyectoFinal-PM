package com.example.proyectofinal.features.movie.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,


    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "pathUrl")
    var pathUrl: String? = null,


    @ColumnInfo(name = "meGusta") // 0 o 1 donde 0 no me gusta 1 me gusta
    var meGusta: Int? = null,

    )