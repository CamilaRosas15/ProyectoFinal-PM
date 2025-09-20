package com.example.proyectofinal.features.dollar.domain.repository

import com.example.proyectofinal.features.dollar.domain.model.DollarModel
import kotlinx.coroutines.flow.Flow

interface IDollarRepository {
    suspend fun getDollar(): Flow<DollarModel>
}
