package com.example.proyectofinal.features.github.domain.model

@JvmInline
value class NickName(val value:String) {
    init {
        require(value.isNotEmpty()){
            "Nickname must not be empty"
        }
    }

    override fun toString(): String = value
}