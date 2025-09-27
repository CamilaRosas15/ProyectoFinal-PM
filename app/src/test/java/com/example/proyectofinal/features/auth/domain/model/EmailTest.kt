package com.example.proyectofinal.features.auth.domain.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class EmailTest {
    @Test()
    fun `test input Data Email`() {
        //arrange
        val inputData = "RobertoCarlos.callisaya@test.COM"
        val expected = "robertocarlos.callisaya@test.com"
        //act
        val emailValueObject = Email.create(inputData)

        //assert
        assertEquals(expected, emailValueObject.value)
    }
}