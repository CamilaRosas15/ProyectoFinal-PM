package com.example.proyectofinal.features.profile.domain.model.vo

@JvmInline
value class Summary(val value: String) {
    init {
        if (value.isBlank()) {
            throw InvalidSummaryException("El resumen no puede estar vacío.")
        }
        if (value.length < 10) {
            throw InvalidSummaryException("El resumen debe tener al menos 10 caracteres.")
        }
        if (value.length > 500) {
            throw InvalidSummaryException("El resumen no puede exceder los 500 caracteres.")
        }
    }
}