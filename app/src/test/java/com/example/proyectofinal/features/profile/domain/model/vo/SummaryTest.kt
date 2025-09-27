package com.example.proyectofinal.features.profile.domain.model.vo

import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class SummaryTest {
    @Test
    fun `Summary creation with valid value should succeed`() {
        val summary = Summary("Esto es un resumen válido con más de 10 caracteres.")
        assertEquals("Esto es un resumen válido con más de 10 caracteres.", summary.value)
    }

    @Test
    fun `Summary creation with blank value should throw InvalidSummaryException`() {
        val exception = assertThrows(InvalidSummaryException::class.java) {
            Summary("")
        }
        assertEquals("El resumen no puede estar vacío.", exception.message)
    }

    @Test
    fun `Summary creation with less than 10 characters should throw InvalidSummaryException`() {
        val exception = assertThrows(InvalidSummaryException::class.java) {
            Summary("Corto")
        }
        assertEquals("El resumen debe tener al menos 10 caracteres.", exception.message)
    }

    @Test
    fun `Summary creation with more than 500 characters should throw InvalidSummaryException`() {
        val longText = "a".repeat(501)
        val exception = assertThrows(InvalidSummaryException::class.java) {
            Summary(longText)
        }
        assertEquals("El resumen no puede exceder los 500 caracteres.", exception.message)
    }

    @Test
    fun `Summaries with same value should be equal`() {
        val summary1 = Summary("Breve descripción.")
        val summary2 = Summary("Breve descripción.")
        assertEquals(summary1, summary2)
    }

}