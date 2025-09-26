package com.example.proyectofinal.features.notification.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.example.proyectofinal.ui.theme.ProyectoFinalTheme

class NotificationScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Opcional, si usas edge-to-edge
        setContent {
            ProyectoFinalTheme { // Envuelve tu Composable con el tema de tu app
                NotificationScreen(modifier = Modifier) // Aquí muestras tu Composable NotificationScreen
            }
        }
    }
}