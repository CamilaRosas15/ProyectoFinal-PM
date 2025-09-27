package com.example.proyectofinal.features.profile.domain.model.vo

import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class NameTest {
    @Test
    fun `Name creation with valid value should succeed`() {
        val name = Name("Juan Perez")
        assertEquals("Juan Perez", name.value)
    }

    @Test
    fun `Name creation with blank value should throw InvalidNameException`() {
        val exception = assertThrows(InvalidNameException::class.java) {
            Name("")
        }
        assertEquals("El nombre no puede estar vacío.", exception.message)
    }

    @Test
    fun `Name creation with less than 2 characters should throw InvalidNameException`() {
        val exception = assertThrows(InvalidNameException::class.java) {
            Name("A")
        }
        assertEquals("El nombre debe tener al menos 2 caracteres.", exception.message)
    }

    @Test
    fun `Name creation with invalid characters should throw InvalidNameException`() {
        val exception = assertThrows(InvalidNameException::class.java) {
            Name("Juan123")
        }
        assertEquals("El nombre solo puede contener letras y espacios.", exception.message)
    }

    @Test
    fun `Names with same value should be equal`() {
        val name1 = Name("Maria")
        val name2 = Name("Maria")
        assertEquals(name1, name2)
    }
}