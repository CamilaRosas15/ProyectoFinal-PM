package com.example.proyectofinal.features.profile.domain.model.vo

@JvmInline
value class Name(val value: String) {
    init {
        if (value.isBlank()) {
            throw InvalidNameException("El nombre no puede estar vacío.")
        }
        if (value.length < 2) {
            throw InvalidNameException("El nombre debe tener al menos 2 caracteres.")
        }
        // Permite letras (incluyendo acentos y ñ/Ñ) y espacios
        if (!value.matches(Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+\$"))) {
            throw InvalidNameException("El nombre solo puede contener letras y espacios.")
        }
    }
}