package com.example.proyectofinal.features.auth.domain.usecase

import com.example.proyectofinal.features.auth.data.repository.AuthRepository
import com.example.proyectofinal.features.auth.domain.model.AuthModel
import com.example.proyectofinal.features.auth.domain.repository.IAuthRepository

class AuthUseCase(private val authRepository: IAuthRepository) {
    suspend operator fun invoke(): Result<AuthModel> {
        return authRepository.getHardcodedAuthCredentials()
    }
}

