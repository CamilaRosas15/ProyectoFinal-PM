package com.example.proyectofinal.features.github.domain.repository

import com.example.proyectofinal.features.github.domain.model.UserModel

interface IGithubRepository {
    suspend fun findByNick(value: String): Result<UserModel>
}