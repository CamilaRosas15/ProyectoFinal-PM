package com.example.proyectofinal.features.dollar.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dollars")
data class DollarEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "officialCompra")
    var officialCompra: String? = null,

    @ColumnInfo(name = "officialVenta")
    var officialVenta: String? = null,

    @ColumnInfo(name = "paraleloCompra")
    var paraleloCompra: String? = null,

    @ColumnInfo(name = "paraleloVenta")
    var paraleloVenta: String? = null,

    @ColumnInfo(name = "timestamp")
    var timestamp: Long = 0)
