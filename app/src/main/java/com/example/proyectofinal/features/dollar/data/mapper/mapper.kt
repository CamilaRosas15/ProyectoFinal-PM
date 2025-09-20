package com.example.proyectofinal.features.dollar.data.mapper

import com.example.proyectofinal.features.dollar.data.database.entity.DollarEntity
import com.example.proyectofinal.features.dollar.domain.model.DollarModel

fun DollarEntity.toModel() : DollarModel {
    return DollarModel(
        dollarOfficial = dollarOfficial,
        dollarParelelo = dollarParelelo
    )
}


fun DollarModel.toEntity() : DollarEntity {
    return DollarEntity(
        dollarOfficial = dollarOfficial,
        dollarParelelo = dollarParelelo)
}
