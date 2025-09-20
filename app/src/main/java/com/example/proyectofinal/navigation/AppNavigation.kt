package com.example.proyectofinal.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectofinal.features.auth.presentation.login.AuthScreen
import com.example.proyectofinal.features.dollar.presentarion.DollarScreen
import com.example.proyectofinal.features.github.presentation.GithubScreen
import com.example.proyectofinal.features.practica.presentation.CardScreen
import com.example.proyectofinal.features.profile.application.ProfileScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Dollar.route
        //startDestination = Screen.Login.route
        //startDestination = Screen.Practica.route
    ) {
        composable(Screen.Github.route) {
            GithubScreen(modifier = Modifier)
        }
        composable(Screen.Home.route) {

        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }
        composable(Screen.Login.route) {
            AuthScreen(navController = navController)
        }
        composable(Screen.Practica.route) {
            CardScreen()
        }
        composable(Screen.Dollar.route) {
            DollarScreen()
        }
    }
}
