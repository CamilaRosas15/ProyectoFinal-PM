package com.example.proyectofinal.features.dollar.data.mapper

import com.example.proyectofinal.features.dollar.data.database.entity.DollarEntity
import com.example.proyectofinal.features.dollar.domain.model.DollarModel

fun DollarEntity.toModel() : DollarModel {
    return DollarModel(
        paraleloCompra = paraleloCompra,
        paraleloVenta = paraleloVenta,
        officialCompra = officialCompra,
        officialVenta = officialVenta,
        timestamp = timestamp
    )
}


fun DollarModel.toEntity() : DollarEntity {
    return DollarEntity(
        paraleloCompra = paraleloCompra,
        paraleloVenta = paraleloVenta,
        officialCompra = officialCompra,
        officialVenta = officialVenta,
        timestamp = timestamp)


}
