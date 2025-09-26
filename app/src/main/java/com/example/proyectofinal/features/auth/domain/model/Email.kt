package com.example.proyectofinal.features.auth.domain.model

@JvmInline
value class Email private constructor(val value: String){
    companion object{
        fun create (raw: String): Email{
            require(raw.isNotEmpty()){
                "Email must not be empty"
            }

            val normalizer = raw.trim().lowercase()
            require(raw.contains("@")){
                "Email must contain '@'"
            }

            return Email(normalizer)
            
        }
    }

    override fun toString(): String = value
}