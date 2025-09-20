package com.example.proyectofinal.features.auth.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectofinal.features.profile.application.ProfileViewModel
import org.koin.androidx.compose.koinViewModel
import com.example.proyectofinal.R


@Composable
fun AuthScreen(
    navController: NavController,
    authViewModel: AuthViewModel = koinViewModel()
) {
    val state by authViewModel.state.collectAsState()
    //val state = authViewModel.state.collectAsState()
    //Log.d("AuthScreen", "Current UI State: $state")
    LaunchedEffect(Unit) {
        authViewModel.showLoginForm()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding(),
            //.background(Color.Magenta),
        contentAlignment = Alignment.Center
    ){
    }
    when (val st = state) {
        is AuthViewModel.LoginUiState.Init -> {
            Text("Iniciando Login...")
        }
        is AuthViewModel.LoginUiState.Loading -> {
            CircularProgressIndicator()
        }
        is AuthViewModel.LoginUiState.Error -> {
            Text("Error: ${st.message}")
        }
        is AuthViewModel.LoginUiState.Success -> {
            //Text("Formulario de Login listo (Email: ${st.email})")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp) // Padding horizontal para el formulario
                    .background(Color.LightGray) // Fondo del Column para depurar si se dibuja
            ) {
                Text(
                    text = "Correo Electrónico",
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = Color.Black // Texto negro para visibilidad
                )
                OutlinedTextField(
                    value = st.email, // El valor viene del ViewModel
                    onValueChange = authViewModel::onEmailChange, // Al escribir, se llama a la función del ViewModel
                    label = { Text("Ingresa tu email") },
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Contraseña",
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = Color.Black
                )
                OutlinedTextField(
                    value = st.password,
                    onValueChange = authViewModel::onPasswordChange,
                    label = { Text("Ingresa tu contraseña") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // Mantenemos el tipo de teclado

                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Valor actual del password: ${st.password}", color = Color.DarkGray, modifier = Modifier.padding(top = 8.dp))
                Text(text = "Valor actual del email: ${st.email}", color = Color.DarkGray, modifier = Modifier.padding(top = 8.dp)) // Para depurar el valor
            }
            //Spacer(modifier = Modifier.height(16.dp)) // Espacio entre email y password
        }
    }
}



/*
* Box(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding(), // <-- Mantenemos el padding seguro
        // contentAlignment = Alignment.Center // Lo quitamos para que la Card se alinee con verticalArrangement.Bottom
    ) {
        // *** ¡¡¡IMAGEN DE FONDO!!! ***
        Image(
            painter = painterResource(id = R.drawable.imagen_login_fondo), // <-- ¡¡¡Verifica que este recurso exista!!!
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Contenido principal (Card con campos)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp), // Padding horizontal para la Card
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom // Empuja la Card a la parte inferior
        ) {
            Spacer(modifier = Modifier.weight(1f)) // Para empujar la Card hacia abajo

            Card( // <-- Aquí comienza la CARD blanca
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(), // Ajusta la altura al contenido
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp), // Esquinas redondeadas arriba
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface) // Fondo blanco de la Card
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp) // Padding interno de la Card
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp) // Espacio entre elementos
                ) {
                    // *** LOGO "now mobile" ***
                    Image(
                        painter = painterResource(id = R.drawable.now_mobile_logo), // <-- ¡¡¡Verifica que este recurso exista!!!
                        contentDescription = "Now Mobile Logo",
                        modifier = Modifier.size(100.dp) // Ajusta el tamaño del logo
                    )
                    Text(text = "Iniciar Sesión", style = MaterialTheme.typography.headlineMedium)

                    when (val st = state) {
                        is AuthViewModel.LoginUiState.Init -> {
                            Text("Cargando formulario...", color = Color.Black)
                        }
                        is AuthViewModel.LoginUiState.Loading -> {
                            CircularProgressIndicator()
                            Text(text = "Cargando datos...", color = Color.Black)
                        }
                        is AuthViewModel.LoginUiState.Error -> {
                            Text(text = "Error: ${st.message}", color = Color.Red)
                        }
                        is AuthViewModel.LoginUiState.Success -> {
                            // --- Campo Correo Electrónico ---
                            OutlinedTextField(
                                value = st.email,
                                onValueChange = authViewModel::onEmailChange,
                                label = { Text("Correo Electrónico") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                modifier = Modifier.fillMaxWidth()
                            )

                            // --- Campo Contraseña ---
                            OutlinedTextField(
                                value = st.password,
                                onValueChange = authViewModel::onPasswordChange,
                                label = { Text("Contraseña") },
                                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                                trailingIcon = {
                                    val image = if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                                        Icon(imageVector = image, contentDescription = "Toggle password visibility")
                                    }
                                },
                                modifier = Modifier.fillMaxWidth()
                            )
                            // Text(text = "Email: ${st.email}, Password: ${st.password}", color = Color.DarkGray) // Para depurar
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp)) // Espacio al final de la Card para separación del borde inferior
        }
    }
*/