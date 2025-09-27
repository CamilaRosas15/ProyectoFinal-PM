package com.example.proyectofinal.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Github: Screen("github")
    object Profile: Screen("profile")
    object Login : Screen("auth")
    object Practica: Screen("practica")
    object Dollar: Screen("dollar")
    object Notification: Screen("notificacion")
    object Movie: Screen("movie")

}