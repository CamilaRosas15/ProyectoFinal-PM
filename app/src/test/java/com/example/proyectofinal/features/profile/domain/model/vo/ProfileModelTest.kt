package com.example.proyectofinal.features.profile.domain.model

import com.example.proyectofinal.features.auth.domain.model.Email
import com.example.proyectofinal.features.github.domain.model.UrlPath
import com.example.proyectofinal.features.profile.domain.model.vo.Cellphone
import com.example.proyectofinal.features.profile.domain.model.vo.Name
import com.example.proyectofinal.features.profile.domain.model.vo.Summary
import org.junit.Assert.assertEquals // Usar Assert.assertEquals de JUnit
import org.junit.Test

class ProfileModelTest { // ¡La clase que contiene todos los tests!

    @Test // Primer test: Creación de ProfileModel con VOs válidos
    fun `ProfileModel creation with valid Value Objects should succeed`() {
        // Arreglar (Arrange) - Definir los Value Objects necesarios para el ProfileModel
        val pathUrl = UrlPath("https://www.viaempresa.cat/uploads/s1/43/99/69/homer.jpg")
        val name = Name("Homero J Simpson") // ¡CORREGIDO! Sin el punto.
        val email = Email.create("homero.simpson@springfieldmail.com")
        val cellphone = Cellphone("+1 (939) 555-7422")
        val summary = Summary("Ciudadano de Springfield y dedicado inspector de seguridad en la Planta Nuclear.")

        // Actuar (Act) - Crear el ProfileModel
        val profile = ProfileModel(pathUrl, name, email, cellphone, summary)

        // Afirmar (Assert) - Verificar que las propiedades del ProfileModel se hayan asignado correctamente
        assertEquals(pathUrl, profile.pathUrl)
        assertEquals(name, profile.name)
        assertEquals(email, profile.email)
        assertEquals(cellphone, profile.cellphone)
        assertEquals(summary, profile.summary)
    }

    @Test // Segundo test: Comparación de dos ProfileModel con los mismos datos
    fun `ProfileModels with same data should be equal`() {
        // Arreglar (Arrange) - Crear dos conjuntos de Value Objects idénticos
        val pathUrl1 = UrlPath("https://www.viaempresa.cat/uploads/s1/43/99/69/homer.jpg")
        val name1 = Name("Homero J Simpson") // ¡CORREGIDO!
        val email1 = Email.create("homero.simpson@springfieldmail.com")
        val cellphone1 = Cellphone("+19395557422")
        val summary1 = Summary("Ciudadano de Springfield y dedicado inspector de seguridad en la Planta Nuclear.")

        val pathUrl2 = UrlPath("https://www.viaempresa.cat/uploads/s1/43/99/69/homer.jpg")
        val name2 = Name("Homero J Simpson") // ¡CORREGIDO!
        val email2 = Email.create("homero.simpson@springfieldmail.com")
        val cellphone2 = Cellphone("+19395557422")
        val summary2 = Summary("Ciudadano de Springfield y dedicado inspector de seguridad en la Planta Nuclear.")

        // Actuar (Act) - Crear dos ProfileModel con los conjuntos de VOs
        val profile1 = ProfileModel(pathUrl1, name1, email1, cellphone1, summary1)
        val profile2 = ProfileModel(pathUrl2, name2, email2, cellphone2, summary2)

        // Afirmar (Assert) - Verificar que ambos ProfileModel son iguales
        assertEquals(profile1, profile2)
    }
}