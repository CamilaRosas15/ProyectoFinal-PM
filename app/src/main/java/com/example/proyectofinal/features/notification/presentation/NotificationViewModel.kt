package com.example.proyectofinal.features.notification.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


import com.example.proyectofinal.features.notification.data.service.getFirebaseMessagingToken
import kotlinx.coroutines.launch

class NotificationViewModel : ViewModel() {

    init {
        // En el bloque init, lanzamos una coroutine para obtener el token.
        // Esto se ejecutará tan pronto como el ViewModel sea creado por la Activity/Composable.
        fetchAndLogFirebaseToken()
    }

    private fun fetchAndLogFirebaseToken() {
        viewModelScope.launch {
            try {
                val fcmToken = getFirebaseMessagingToken() // Llama a la función suspend
                Log.d("NotificationViewModel", "FCM Token recuperado: $fcmToken")
                // Aquí podrías actualizar un LiveData/StateFlow para la UI,
                // o enviarlo a un repositorio si necesitas persistirlo o subirlo a un servidor.
            } catch (e: Exception) {
                Log.e("NotificationViewModel", "Error al recuperar el FCM Token: ${e.message}")
            }
        }
    }
}