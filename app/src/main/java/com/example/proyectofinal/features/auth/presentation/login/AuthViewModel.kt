package com.example.proyectofinal.features.auth.presentation.login

import androidx.lifecycle.ViewModel
import com.example.proyectofinal.features.auth.domain.usecase.AuthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AuthViewModel(
    val authUseCase: AuthUseCase
): ViewModel() {
    sealed class LoginUiState{
        object Init : LoginUiState()
        object Loading : LoginUiState()
        class Error(val message: String) : LoginUiState()
        data class Success(
            val email: String = "",
            val password: String = "",
            //val rememberMe: Boolean = false,
            //val isAuthenticated: Boolean = false
        ) : LoginUiState()
    }
    private var _state = MutableStateFlow<LoginUiState>(LoginUiState.Init)

    val state: StateFlow<LoginUiState> = _state.asStateFlow()

    fun onEmailChange(newEmail: String) {
        if (_state.value is LoginUiState.Success) {
            _state.update { currentUiState ->
                (currentUiState as LoginUiState.Success).copy(email = newEmail)
            }
        }
    }

    fun onPasswordChange(newPassword: String) {
        if (_state.value is LoginUiState.Success) {
            _state.update { currentUiState ->
                (currentUiState as LoginUiState.Success).copy(password = newPassword)
            }
        }
    }
    fun showLoginForm() {
        _state.value = LoginUiState.Success()
    }
}

