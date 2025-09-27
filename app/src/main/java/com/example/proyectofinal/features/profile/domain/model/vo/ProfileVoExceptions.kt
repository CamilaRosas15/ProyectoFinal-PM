package com.example.proyectofinal.features.profile.domain.model.vo

sealed class ProfileVoException(message: String) : IllegalArgumentException(message)

class InvalidCellphoneException(message: String) : ProfileVoException(message)
class InvalidNameException(message: String) : ProfileVoException(message)
class InvalidSummaryException(message: String) : ProfileVoException(message)
