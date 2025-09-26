package com.example.proyectofinal.features.github.domain.model

import org.junit.Test

class UrlPathTest {
    @Test(expected = Exception::class)
    fun `test UrlPath`() {
        UrlPath("lgkajf")
        UrlPath("")
    }
}