package com.example.proyectofinal.features.profile.domain.model.vo

@JvmInline
value class Cellphone(val value: String) {
    init {
        if (value.isBlank()) {
            throw InvalidCellphoneException("El número de teléfono no puede estar vacío.")
        }

        val phoneRegex = Regex("^\\+?[0-9\\s\\-()]{7,20}$")
        if (!value.matches(phoneRegex)) {
            throw InvalidCellphoneException("Formato de número de teléfono inválido.")
        }
    }
}