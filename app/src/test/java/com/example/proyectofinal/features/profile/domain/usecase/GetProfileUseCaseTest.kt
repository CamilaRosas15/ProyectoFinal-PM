package com.example.proyectofinal.features.profile.domain.usecase

import com.example.proyectofinal.features.profile.domain.model.ProfileModel
import com.example.proyectofinal.features.profile.domain.repository.IProfileRepository
import com.example.proyectofinal.features.auth.domain.model.Email
import com.example.proyectofinal.features.github.domain.model.UrlPath
import com.example.proyectofinal.features.profile.domain.model.vo.Cellphone
import com.example.proyectofinal.features.profile.domain.model.vo.Name
import com.example.proyectofinal.features.profile.domain.model.vo.Summary
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

// Importaciones de Mockito Kotlin
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

// ¡¡¡Importación de la clase Result de Kotlin estándar!!!
import kotlin.Result


@OptIn(ExperimentalCoroutinesApi::class)
class GetProfileUseCaseTest {

    private lateinit var mockProfileRepository: IProfileRepository
    private lateinit var getProfileUseCase: GetProfileUseCase

    @Before
    fun setup() {
        mockProfileRepository = mock()
        getProfileUseCase = GetProfileUseCase(mockProfileRepository)
    }

    @Test
    fun `invoke should return success when repository returns success`() = runTest {
        // Given: Prepara un ProfileModel esperado con Value Objects válidos
        val expectedProfile = ProfileModel(
            pathUrl = UrlPath("https://example.com/test.jpg"), // ¡¡¡Asegúrate de que sea 'https' aquí!!!
            name = Name("Test User"),
            email = Email.create("test@user.com"),
            cellphone = Cellphone("+1234567890"),
            summary = Summary("A short bio for testing purposes.")
        )
        // Cuando el mock del repositorio llame a fetchData(), devolverá un resultado exitoso
        whenever(mockProfileRepository.fetchData()).thenReturn(Result.success(expectedProfile))

        // When: Ejecuta el UseCase
        val result = getProfileUseCase.invoke()

        // Then: Verifica que el resultado es exitoso y contiene el perfil esperado
        assertTrue(result.isSuccess)
        assertNull(result.exceptionOrNull())
        assertNotNull(result.getOrNull())
        assertEquals(expectedProfile, result.getOrNull())
    }

    @Test
    fun `invoke should return error when repository returns error`() = runTest {
        // Given: Prepara una excepción que el repositorio podría lanzar
        val expectedException = RuntimeException("Network Error")
        // Cuando el mock del repositorio llame a fetchData(), devolverá un resultado con error
        whenever(mockProfileRepository.fetchData()).thenReturn(Result.failure(expectedException))

        // When: Ejecuta el UseCase
        val result = getProfileUseCase.invoke()

        // Then: Verifica que el resultado es un error y contiene la excepción esperada
        assertTrue(result.isFailure)
        assertNotNull(result.exceptionOrNull())
        assertNull(result.getOrNull())
        assertEquals(expectedException, result.exceptionOrNull())
    }
}