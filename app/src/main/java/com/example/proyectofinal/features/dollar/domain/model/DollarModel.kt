package com.example.proyectofinal.features.dollar.domain.model


data class DollarModel(
    val officialCompra: String? = null,
    val officialVenta: String? = null,
    val paraleloCompra: String? = null,
    val paraleloVenta: String? = null,
    val timestamp: Long = System.currentTimeMillis(),
    //val updatedAt: Long? = null
)
