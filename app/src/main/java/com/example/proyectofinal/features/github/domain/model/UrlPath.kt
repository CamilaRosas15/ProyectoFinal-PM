package com.example.proyectofinal.features.github.domain.model


@JvmInline
value class UrlPath(val value: String) {
    init{
        require(value.startsWith("https://")){
            "UrlPath must start with 'https'"
        }
        require(value.isNotEmpty()){
            "UrlPath must not be empty"
        }
    }
}