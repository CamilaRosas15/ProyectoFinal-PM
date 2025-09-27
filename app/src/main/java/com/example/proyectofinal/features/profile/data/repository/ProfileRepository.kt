package com.example.proyectofinal.features.profile.data.repository

import com.example.proyectofinal.features.auth.domain.model.Email
import com.example.proyectofinal.features.github.domain.model.UrlPath
import com.example.proyectofinal.features.profile.domain.model.ProfileModel
import com.example.proyectofinal.features.profile.domain.model.vo.Cellphone
import com.example.proyectofinal.features.profile.domain.model.vo.Name
import com.example.proyectofinal.features.profile.domain.model.vo.Summary
import com.example.proyectofinal.features.profile.domain.repository.IProfileRepository

class ProfileRepository: IProfileRepository {
    override suspend fun fetchData(): Result<ProfileModel> {
        return Result.success(
            ProfileModel(
                name = Name("Homero J Simpson"),
                email = Email.create("homero.simpson@springfieldmail.com"),
                cellphone = Cellphone("+19395557422"),
                pathUrl = UrlPath("https://www.viaempresa.cat/uploads/s1/43/99/69/homer.jpg"),
                summary = Summary("Ciudadano de Springfield y dedicado inspector de seguridad en la Planta Nuclear.") // ¡Instanciar con Summary VO!
            )
        )
    }
}