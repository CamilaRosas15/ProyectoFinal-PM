package com.example.proyectofinal.features.auth.domain.repository

import com.example.proyectofinal.features.auth.domain.model.AuthModel

interface IAuthRepository {
    //suspend fun getHardcodedAuthCredentials(): AuthModel
    suspend fun getHardcodedAuthCredentials(): Result<AuthModel>
}