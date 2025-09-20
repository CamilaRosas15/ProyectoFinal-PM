package com.example.proyectofinal.features.auth.data.repository

import com.example.proyectofinal.features.auth.domain.model.AuthModel
import com.example.proyectofinal.features.auth.domain.repository.IAuthRepository
import kotlinx.coroutines.delay

class AuthRepository : IAuthRepository {

    override suspend fun getHardcodedAuthCredentials(): Result<AuthModel> { // <-- Ahora coincide con la interfaz
        delay(1500)
        return Result.success(AuthModel(
            email = "homero.simpson@springfieldmail.com",
            password = "hola123"
        )
        )
    }
}

        /*return Result.success(
            ProfileModel(
                name = "Homero J. Simpson",
                email = "homero.simpson@springfieldmail.com",
                cellphone = "+1 (939) 555‑7422",
                pathUrl = "https://www.viaempresa.cat/uploads/s1/43/99/69/homer.jpg",
                summary = "Ciudadano de Springfield y dedicado inspector de seguridad en la Planta Nuclear."
            )
        )
    }*/

