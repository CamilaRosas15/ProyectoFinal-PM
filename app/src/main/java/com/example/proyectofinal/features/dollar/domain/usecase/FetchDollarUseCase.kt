package com.example.proyectofinal.features.dollar.domain.usecase

import com.example.proyectofinal.features.dollar.domain.model.DollarModel
import com.example.proyectofinal.features.dollar.domain.repository.IDollarRepository
import kotlinx.coroutines.flow.Flow

class FetchDollarUseCase(
    val repository: IDollarRepository
) {


    suspend fun invoke(): Flow<DollarModel> {
        return repository.getDollar()
    }
}
