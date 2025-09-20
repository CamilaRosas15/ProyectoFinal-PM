package com.example.proyectofinal.features.dollar.data.repository

import com.example.proyectofinal.features.dollar.data.datasource.DollarLocalDataSource
import com.example.proyectofinal.features.dollar.data.datasource.RealTimeRemoteDataSource
import com.example.proyectofinal.features.dollar.domain.model.DollarModel
import com.example.proyectofinal.features.dollar.domain.repository.IDollarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach

class DollarRepository(val realTimeRemoteDataSource: RealTimeRemoteDataSource, val localDataSource: DollarLocalDataSource
): IDollarRepository {


    override suspend fun getDollar(): Flow<DollarModel> {
//        //return flow {
//          //  emit(DollarModel("6.96", "12.6"))
//        //}
        return realTimeRemoteDataSource.getDollarUpdates()
            .onEach {
                localDataSource.insert(it)
            }
    }
}
