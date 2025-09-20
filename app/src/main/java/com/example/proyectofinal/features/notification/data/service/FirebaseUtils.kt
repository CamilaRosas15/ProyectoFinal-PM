package com.example.proyectofinal.features.notification.data.service

//class FirebaseUtils {
//}

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

// Este es el método que obtenemos para recuperar el token de registro de Firebase.
suspend fun getFirebaseMessagingToken(): String = suspendCoroutine { continuation ->
    FirebaseMessaging.getInstance().token
        .addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("FCM_TOKEN_LOG", "Fetching FCM registration token failed", task.exception)
                continuation.resumeWithException(task.exception ?: Exception("Unknown error"))
                return@addOnCompleteListener
            }
            val token = task.result
            Log.d("FCM_TOKEN_LOG", "FCM Token obtained: $token") // ¡Este es el log clave!
            continuation.resume(token ?: "")
        }
}