package com.example.proyectofinal.features.profile.domain.model

import com.example.proyectofinal.features.auth.domain.model.Email
import com.example.proyectofinal.features.github.domain.model.UrlPath
import com.example.proyectofinal.features.profile.domain.model.vo.Cellphone
import com.example.proyectofinal.features.profile.domain.model.vo.Name
import com.example.proyectofinal.features.profile.domain.model.vo.Summary

data class ProfileModel(
    val pathUrl: UrlPath,
    val name: Name,
    val email: Email,
    val cellphone: Cellphone,
    val summary: Summary
)