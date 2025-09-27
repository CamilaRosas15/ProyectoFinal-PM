package com.example.proyectofinal.features.profile.domain.repository

import com.example.proyectofinal.features.profile.domain.model.ProfileModel

interface IProfileRepository {
    suspend fun fetchData(): Result<ProfileModel>
}