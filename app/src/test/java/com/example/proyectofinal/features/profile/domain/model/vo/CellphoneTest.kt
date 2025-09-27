package com.example.proyectofinal.features.profile.domain.model.vo

import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class CellphoneTest {

    @Test
    fun `Cellphone creation with valid value should succeed`() {
        val cellphone = Cellphone("+1234567890")
        assertEquals("+1234567890", cellphone.value)
    }

    @Test
    fun `Cellphone creation with blank value should throw InvalidCellphoneException`() {
        val exception = assertThrows(InvalidCellphoneException::class.java) { Cellphone("") }
        assertEquals("El número de teléfono no puede estar vacío.", exception.message)
    }

    @Test
    fun `Cellphone creation with invalid format should throw InvalidCellphoneException`() {
        val exception = assertThrows(InvalidCellphoneException::class.java) { Cellphone("123abc") }
        assertEquals("Formato de número de teléfono inválido.", exception.message)
    }

    @Test
    fun `Cellphone creation with too short value should throw InvalidCellphoneException`() {
        val exception = assertThrows(InvalidCellphoneException::class.java) { Cellphone("+123") } // Menos de 7 caracteres
        assertEquals("Formato de número de teléfono inválido.", exception.message)
    }

    @Test
    fun `Cellphones with same value should be equal`() {
        val cellphone1 = Cellphone("+584121234567")
        val cellphone2 = Cellphone("+584121234567")
        assertEquals(cellphone1, cellphone2)
    }
}